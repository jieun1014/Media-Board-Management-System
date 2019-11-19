package com.transfer.video.vtms.agent;

import java.util.Random;

import com.google.gson.Gson;
import com.transfer.video.vtms.device.Device;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AgentServiceImpl implements AgentService {
	public static final MediaType MEDIA_TYPE_HTML = MediaType.get("tex/html; charset=utf-8");

	@Override
	public Device transferDevice() {
		// 1. 디바이스 정보를 조회한다.
		AgentMapper agentMapper = new AgentMapperImpl();
		Device device = agentMapper.selectDeviceInfo(); // 호스트 정보와 ip정보를 가지고 있음

		// 2. ip가 null이 아닌가?
		if (!(null == device.getIp())) {
			// 3. 접근키를 조회한다.
			device.setAccessKey(agentMapper.selectAccessKey());

			// 접근키를 검증한다.
			if (null == device.getAccessKey()) {
				// 접근키 생성
				StringBuffer accessKey = new StringBuffer();
				accessKey.append(device.getIp());

				Random randomAlphabet = new Random();
				for (int i = 0; i < 5; i++) {
					accessKey.append(String.valueOf((char) ((int) (randomAlphabet.nextInt(26)) + 65)));
				}
				device.setAccessKey(accessKey.toString());

				// 4. 접근 키 등록한다.
				agentMapper.insertAccessKey(device.getAccessKey());
			}

			// 5. 서버 ip를 조회한다.
			String serverIP = agentMapper.selectServerInfo();
			
			StringBuffer url = new StringBuffer();
			url.append("http://");
			url.append(serverIP);
			url.append("/test?");
			url.append("ip=" + device.getIp());
			url.append("&hostName=" + device.getHostName());
			url.append("&accessKey=" + device.getAccessKey());

			//TODO 디바이스 정보 전송 test
			System.out.println(url.toString());
			
			RequestBody body = RequestBody.create("", MEDIA_TYPE_HTML);
			Request request = new Request.Builder().url(url.toString()).post(body).build();

			Response response = null;
			try {
				// 6. 전송 시도 횟수가 2회 이하인가?
				for (int i = 0; i <= 2; i++) {
					// 7. 디바이스 정보를 관리 시스템으로 전송한다.
					response = new OkHttpClient().newCall(request).execute();
					
					//TODO json Parsing 테스트
					String json = response.body().string(); 
					Gson gson = new Gson();
					Message message = gson.fromJson(json, Message.class);
					System.out.println(message.getCode());
					System.out.println(message.getMessage());

					
					
					// 8. 전송이 성공적으로 이루어졌는가?
					if (200 == response.code()) {
						break;
					}else {
						response.body();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (response != null) {
					response.close();
				}
			}
		}
		
		return device;
	}
}
