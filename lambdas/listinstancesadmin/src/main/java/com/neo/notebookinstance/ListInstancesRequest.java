package com.neo.notebookinstance;


import com.amazonaws.services.sagemaker.model.Tag;



public class ListInstancesRequest {

	private String tagKey;
	private String tagValue;


	
	public ListInstancesRequest(String tagKey, String tagValue) {
		
		this.tagKey = tagKey;
		this.tagValue = tagValue;
	}



	public String getTagKey() {
		return tagKey;
	}



	public void setTagKey(String tagKey) {
		this.tagKey = tagKey;
	}



	public String getTagValue() {
		return tagValue;
	}



	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}



	public ListInstancesRequest() {
		
	}

	
	
}
