package com.neo.notebookinstance;

import java.util.ArrayList;
import com.amazonaws.services.sagemaker.model.*;

public class ListInstancesResponse {

	private ArrayList<NotebookInstanceSummary> notebooksSummaryList;

	public ListInstancesResponse(ArrayList<NotebookInstanceSummary> notebooksSummaryList) {
		
		this.notebooksSummaryList = notebooksSummaryList;
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
