package com.transfer.video.vtms.agent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.transfer.video.vtms.device.Device;

public class AgentMapperImpl implements AgentMapper {
	private Properties properties = new Properties();
	private File file = 
			new File("C:\\sw-workspace\\vtms\\src\\main\\java\\com\\transfer\\video\\vtms\\agent\\agent.properties");

	public Device selectDeviceInfo() {

		BufferedReader bufferedReader = null;
		Process process = null;

		Device device = new Device();

		try {
			properties.load(new FileInputStream(file));

			String cmd = properties.getProperty("device.cmd");
			process = Runtime.getRuntime().exec(cmd);
			bufferedReader = new BufferedReader(
					new InputStreamReader(process.getInputStream(), properties.getProperty("charset")));

			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				// 호스트 이름 가져와서 Agent에 set 하기
				if ((line.contains("호스트 이름"))) {
					String hostName = line.substring((line.lastIndexOf(" ") + 1));
					device.setHostName(hostName);
				}

				// IP 가져와서 set 하기
				if (line.contains("무선 LAN 어댑터 Wi-Fi")) {
					while (true) {
						line = bufferedReader.readLine();

						if (line.contains("미디어 상태")) { // 미연결된 상태
							break;
						}

						if (line.contains("IPv4")) {
							String ip = line.substring(line.indexOf(":") + 2, line.lastIndexOf("("));

							device.setIp(ip);
							break;
						}
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception e) {
			}
		}

		return device;
	}

	@Override
	public void insertAccessKey(String accessKey) {
		// 프로퍼티 파일 읽어오기
		try {
			properties.load(new FileInputStream(file));

			// 프로퍼티 등록
			properties.setProperty("accessKey", accessKey);

			// 프로퍼티 저장
			properties.store(new FileOutputStream(file), "accessKey");

			// 접근 키 등록 결과
			System.out.println(properties.getProperty("accessKey"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String selectAccessKey() {
		String accessKey = null;
		try {
			// 프로퍼티 파일 읽어오기
			properties.load(new FileInputStream(file));

			// 프로퍼티 가져오기
			accessKey = properties.getProperty("accessKey");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accessKey;
	}

	@Override
	public String selectServerInfo() {
		String serverIP = "";
		try {
			properties.load(new FileInputStream(file));
			serverIP = properties.getProperty("server.ip");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverIP;
	}
}
