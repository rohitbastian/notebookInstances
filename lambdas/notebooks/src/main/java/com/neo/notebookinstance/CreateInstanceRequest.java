package com.neo.notebookinstance;



import com.amazonaws.services.sagemaker.model.Tag;


public class CreateInstanceRequest {

	private String instanceName;
	private String instanceType;
	private String tagKey;
	private String tagValue;
	public final String ROLE_ARN="arn:aws:iam::356832206364:role/service-role/AmazonSageMaker-ExecutionRole-20180626T115842";	
	public final String LIFECYCLE_CONFIG="installRKernel";
	
	
	public CreateInstanceRequest(String instanceName, String instanceType, String tagKey, String tagValue) {
		this.instanceName = instanceName;
		this.instanceType = instanceType;
		this.tagKey = tagKey;
		this.tagValue=tagValue;
	}
	
	public CreateInstanceRequest() {
		
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
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



}
