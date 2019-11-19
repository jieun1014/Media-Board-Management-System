package com.transfer.video.vtms.video;

import java.io.Serializable;

public class TransferHistory implements Serializable {
	private int no;
	private String deviceIp;
	private String name;
	private String place;
	private String videoName;
	private String transferDate;
	private double fileSize;
	private int playTime;
	private String note;
	
	public TransferHistory(int no, String deviceIp, String name, String place, String videoName, String transferDate,
			double fileSize, int playTime, String note) {
		this.no = no;
		this.deviceIp = deviceIp;
		this.name = name;
		this.place = place;
		this.videoName = videoName;
		this.transferDate = transferDate;
		this.fileSize = fileSize;
		this.playTime = playTime;
		this.note = note;
	}

	public TransferHistory() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


}
