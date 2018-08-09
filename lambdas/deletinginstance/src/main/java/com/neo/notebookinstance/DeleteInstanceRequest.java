package com.neo.notebookinstance;


public class DeleteInstanceRequest {

	private String instanceName;
		
	public DeleteInstanceRequest(String instanceName) {
		this.instanceName = instanceName;

	}
	
	public DeleteInstanceRequest() {
		
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	}
