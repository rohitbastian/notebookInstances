package com.neo.notebookinstance;

import java.util.ArrayList;
import com.amazonaws.services.sagemaker.model.*;

public class InstanceDetailsResponse {

	private String instancestatus;
	private String instanceType;
	private String instanceName;
	public String getInstancestatus() {
		return instancestatus;
	}
	public void setInstancestatus(String instancestatus) {
		this.instancestatus = instancestatus;
	}
	public String getInstanceType() {
		return instanceType;
	}
	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public InstanceDetailsResponse(String instancestatus, String instanceType, String instanceName) {
		
		this.instancestatus = instancestatus;
		this.instanceType = instanceType;
		this.instanceName = instanceName;
	}
	public InstanceDetailsResponse() {
		
	}


	
	/*
	public String toString()
	{
		StringBuilder toString = new StringBuilder();
		for(NotebookInstanceSummary notebook : notebooksSummaryList) {
			toString.append(notebook.getNotebookInstanceName() + " " + notebook.getNotebookInstanceStatus());
			toString.append("\n");
		}
		return new String(toString);
	}
	*/
	
}
