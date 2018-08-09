package com.neo.notebookinstance;


import com.amazonaws.services.sagemaker.model.Tag;



public class InstanceDetailsRequest {
	
	private String instanceName;
	
	public InstanceDetailsRequest(String instanceName) {
		
		this.instanceName = instanceName;
	}

	public String getInstanceName() {
		return instanceName;
	}


	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}


	public InstanceDetailsRequest() {
		
	}

	
	
}
