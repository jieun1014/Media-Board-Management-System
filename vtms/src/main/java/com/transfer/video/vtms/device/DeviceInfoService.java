package com.transfer.video.vtms.device;

import java.io.File;
import java.util.List;

import com.transfer.video.vtms.video.TransferHistory;

public interface DeviceInfoService {
	public List<Device> getDevicesInfo(Device device);
	public Device getDeviceInfo(Device device);
	public boolean addDeviceInfo(Device device);
	public void editDeviceInfo(Device device, File video, TransferHistory transferHistory) throws Exception;	
	public boolean removeDeviceInfo(String ip);	
}
