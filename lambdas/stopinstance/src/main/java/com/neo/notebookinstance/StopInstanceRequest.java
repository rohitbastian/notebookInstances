package com.neo.notebookinstance;

public class StopInstanceRequest {

	private String instanceName;

	
	public final String ROLE_ARN="arn:aws:iam::356832206364:role/service-role/AmazonSageMaker-ExecutionRole-20180626T115842";	
	public final String LIFECYCLE_CONFIG="installRKernel";
	
	
	public StopInstanceRequest(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public StopInstanceRequest() {
		
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

}
