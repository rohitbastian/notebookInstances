package com.neo.notebookinstance;

public class StartInstanceResponse {

	private String preSignedUrl;
	private String message;
	public String getpreSignedUrl() {
		return this.preSignedUrl;
	}
	
	public void setpreSignedUrl(String preSignedUrl) {
		this.preSignedUrl=preSignedUrl;
	}
	
	public String getmessage() {
		return this.preSignedUrl;
	}
	
	public void setmessage(String message) {
		this.preSignedUrl=preSignedUrl;
	}
	
	public StartInstanceResponse() {
		
	}
	
	public StartInstanceResponse(String preSignedUrl, String message) {
		this.preSignedUrl=preSignedUrl;
		this.message=message;
	}
	
	
}
