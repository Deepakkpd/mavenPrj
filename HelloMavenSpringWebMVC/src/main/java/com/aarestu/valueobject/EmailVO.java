package com.aarestu.valueobject;

public class EmailVO {
	private String id;
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EmailVO [id=" + id + ", emailId=" + emailId + "]";
	}

}
