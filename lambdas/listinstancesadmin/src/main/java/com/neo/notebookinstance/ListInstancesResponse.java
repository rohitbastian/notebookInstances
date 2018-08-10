package com.neo.notebookinstance;

import java.util.ArrayList;
import com.amazonaws.services.sagemaker.model.*;

public class ListInstancesResponse {

	private ArrayList<NotebookInstanceSummary> notebooksSummaryList;
	private String[] owners;

	public ListInstancesResponse(ArrayList<NotebookInstanceSummary> notebooksSummaryList, String[] owners) {
		
		
		this.notebooksSummaryList = notebooksSummaryList;
		this.owners =owners;
	}
	public String[] getOwners() {
		return owners;
	}
	public void setOwners(String[] owners) {
		this.owners = owners;
	}
	public ListInstancesResponse() {
		
	}

	public ArrayList<NotebookInstanceSummary> getNotebooksSummaryList() {
		return notebooksSummaryList;
	}

	public void setNotebooksSummaryList(ArrayList<NotebookInstanceSummary> notebooksSummaryList) {
		this.notebooksSummaryList = notebooksSummaryList;
	}
	
	public String toString()
	{
		StringBuilder toString = new StringBuilder();
		for(NotebookInstanceSummary notebook : notebooksSummaryList) {
			toString.append(notebook.getNotebookInstanceName() + " " + notebook.getNotebookInstanceStatus());
			toString.append("\n");
		}
		return new String(toString);
	}
	
	
}
