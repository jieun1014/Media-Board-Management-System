package com.transfer.video.vtms.device;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devicestatus")
public class DeviceConnStatusController {
	@Autowired
	private DeviceConnStatusService deviceConnStatusService;

	@GetMapping(value = "/{ip}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> editDeviceStatus(@PathVariable String ip) {
		Device device = new Device();
		device.setIp(ip);

		boolean connStatus = this.deviceConnStatusService.editDeviceConnStatus(device);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("connStatus", connStatus);

		return result;
	}
}
