package com.transfer.video.vtms.device;

import java.io.Serializable;

public class Device implements Serializable {
	private static final long serialVersionUID = -5911227562726594748L;

	private String ip;
	private String name;
	private String hostName;
	private String accessKey;
	private String place;
	private String registerDate;
	private String transferDate;
	private String connStatus;
	private String connStatusName;
	private String status;
	private String port;

	public Device() {
	}

	public Device ip(String ip) {
		this.ip = ip;
		return this;
	}

	public Device status(String status) {
		this.status = status;
		return this;
	}

	public Device(String ip, String status) {
		this(ip, null, null, null, null, null, null, null, null, status, null);
	}

	public Device(String ip, String name, String hostName, String accessKey, String place, String registerDate,
			String transferDate, String connStatus, String connStatusName, String status, String port) {
		this.ip = ip;
		this.name = name;
		this.hostName = hostName;
		this.accessKey = accessKey;
		this.place = place;
		this.registerDate = registerDate;
		this.transferDate = transferDate;
		this.connStatus = connStatus;
		this.connStatusName = connStatusName;
		this.status = status;
		this.port = port;
	}

	public String getConnStatusName() {
		return connStatusName;
	}

	public void setConnStatusName(String connStatusName) {
		this.connStatusName = connStatusName;
	}

	public Device(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public String getConnStatus() {
		return connStatus;
	}

	public void setConnStatus(String connStatus) {
		this.connStatus = connStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
