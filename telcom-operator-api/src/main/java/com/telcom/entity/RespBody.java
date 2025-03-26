package com.telcom.entity;

import org.springframework.stereotype.Component;

@Component
public class RespBody {
	
	public RespBody() {
		
	}
	
	public RespBody(String respponseCode) {
		super();
		this.respponseCode = respponseCode;
	}

	private String respponseCode;

	public String getRespponseCode() {
		return respponseCode;
	}

	public void setRespponseCode(String respponseCode) {
		this.respponseCode = respponseCode;
	}

}
