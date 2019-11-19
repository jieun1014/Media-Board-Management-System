package com.transfer.video.vtms.device;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper {
	public List<Device> selectAll(Device device);	
	public Device select(Device device);	
	public void insert(Device device);
	public void update(Device device);	
}