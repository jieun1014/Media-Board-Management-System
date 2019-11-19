package com.transfer.video.vtms.common;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = -1930964514182304546L;

	private String id;
	private String password;
	
	public Account() {
	}

	public void Accont(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
