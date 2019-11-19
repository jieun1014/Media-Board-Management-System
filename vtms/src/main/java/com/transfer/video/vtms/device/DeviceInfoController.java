package com.transfer.video.vtms.device;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.transfer.video.vtms.video.TransferHistory;

@RestController
public class DeviceInfoController {
	@Autowired
	private DeviceInfoService deviceInfoService;

	/**
	 * 디바이스 정보 목록 화면 출력
	 * */
	@GetMapping("/device")
	public ModelAndView getDevicesInfo() {
		return new ModelAndView("/device/list");
	}
	/**
	 * 디바이스 정보 목록 조회
	 * */	
	@GetMapping(value = "/device", consumes = "application/json")
	public List<Device> getDevicesInfo(String connStatus) {
		Device device = new Device();
		device.setConnStatus(connStatus);

		return this.deviceInfoService.getDevicesInfo(device);
	}
	
	/**
	 * 디바이스 정보 상세 조회
	 * */
	@GetMapping("/device/{ip}")
	public ModelAndView getDeviceInfo(@PathVariable("ip") String ip,@RequestParam(required = false) String msg) {
		ModelAndView mav = new ModelAndView("/device/detail");
		mav.addObject("msg", msg);
	
		
		Device device = this.deviceInfoService.getDeviceInfo(new Device(ip, null));
		mav.addObject("device", device);
		
		return mav;
	}
	
	/**
	 * 디바이스 정보 등록
	 * */
	@PostMapping(value = "/device/agent", consumes = "application/json")
	public String addDeviceInfo(HttpServletRequest request) {
		Device device = new Device();
		device.setIp(request.getParameter("ip"));
		device.setHostName(request.getParameter("hostName"));
		device.setAccessKey(request.getParameter("accessKey"));
		
		boolean isResult = this.deviceInfoService.addDeviceInfo(device);
		
		String message = null;
		if (isResult) {
			message = "success";
		} else {
			message = "fail";
		}
		
		return message;
	}
	
	/**
	 * 디바이스 정보 수정
	 * */
	@PostMapping("/device/{ip}")
	public ModelAndView editDeviceInfo(Device parameter, @RequestParam(required = false) MultipartFile video, String note, int playTime) 
			throws Exception {	
		File target = null;
		TransferHistory transferHistory = new TransferHistory();
		try {
			target = new File(video.getOriginalFilename());
			FileCopyUtils.copy(video.getInputStream(), new FileOutputStream(target));
			
			transferHistory.setPlayTime(playTime);
			transferHistory.setNote(note);
		} catch(Exception e) {
			target = null;
		}
		
		ModelAndView mav = new ModelAndView(new RedirectView("/device/" + parameter.getIp()));
		
		try {
			this.deviceInfoService.editDeviceInfo(parameter, target, transferHistory);
			mav.addObject("msg", "디바이스 정보 수정이 완료되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("msg", "디바이스 정보 수정에 실패했습니다.");
		}
		
		return mav;
	}
	
	/**
	 * 디바이스 정보 삭제
	 * */
	@DeleteMapping("/device/{ip}")
	public ModelAndView removeDeviceInfo(@PathVariable("ip") String ip, RedirectAttributes redirectAttributes) {
		boolean isResult = this.deviceInfoService.removeDeviceInfo(ip);
		if (isResult) {
			return new ModelAndView(new RedirectView("/device"));
		} else {
			redirectAttributes.addAttribute("msg", "드바이스 삭제  도중에 문제가 발생하였습니다.");

			return new ModelAndView(new RedirectView("/device/" + ip));
		}
	}
}
