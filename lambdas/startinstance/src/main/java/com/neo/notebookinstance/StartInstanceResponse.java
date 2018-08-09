package com.neo.notebookinstance;

public class StartInstanceResponse {

	private String preSignedUrl;
	
	public String getpreSignedUrl() {
		return this.preSignedUrl;
	}
	
	public void setpreSignedUrl(String preSignedUrl) {
		this.preSignedUrl=preSignedUrl;
	}
	
	public StartInstanceResponse() {
		
	}
	
	public StartInstanceResponse(String preSignedUrl) {
		this.preSignedUrl=preSignedUrl;
	}
	
	
}
