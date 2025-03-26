package com.customer.exception;

public class Data {
	
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String responseCode;
	private String messgae;
	public Data(String responseCode, String messgae) {
		super();
		this.responseCode = responseCode;
		this.messgae = messgae;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public Data(String responseCode) {
		super();
		this.responseCode = responseCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

}
