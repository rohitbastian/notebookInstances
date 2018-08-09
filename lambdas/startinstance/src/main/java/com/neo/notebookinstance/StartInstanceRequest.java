package com.neo.notebookinstance;

public class StartInstanceRequest {

	private String instanceName;

	
	public final String ROLE_ARN="arn:aws:iam::356832206364:role/service-role/AmazonSageMaker-ExecutionRole-20180626T115842";	
	public final String LIFECYCLE_CONFIG="installRKernel";
	
	
	public StartInstanceRequest(String instanceName) {
		this.instanceName = instanceName;
	}
	
	public StartInstanceRequest() {
		
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

}
