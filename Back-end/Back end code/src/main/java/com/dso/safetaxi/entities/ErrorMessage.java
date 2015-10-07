package com.dso.safetaxi.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	private String documention;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getDocumention() {
		return documention;
	}
	
	public void setDocumention(String documention) {
		this.documention = documention;
	}
	
	public ErrorMessage() {
	}
	
	public ErrorMessage(String errorMessage, int errorCode, String documention) {
		super();
		
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documention = documention;
	}
	
}
