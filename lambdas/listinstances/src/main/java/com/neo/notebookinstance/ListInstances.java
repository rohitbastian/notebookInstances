package com.neo.notebookinstance;



import java.util.ArrayList;
import com.amazonaws.services.sagemaker.*;
import com.amazonaws.services.sagemaker.model.*;
import com.neo.notebookinstance.ListInstancesRequest;
import com.neo.notebookinstance.ListInstancesResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class ListInstances implements RequestHandler<ListInstancesRequest , ListInstancesResponse> {
	AmazonSageMaker sagemaker = AmazonSageMakerClientBuilder.standard().withRegion("us-east-1").build();
	public ListInstancesResponse handleRequest(ListInstancesRequest request, Context context) {
		
		ListNotebookInstancesRequest listNotebookInstancesRequest = new ListNotebookInstancesRequest();
		
		ListNotebookInstancesResult listNotebookInstancesResult = sagemaker.listNotebookInstances(listNotebookInstancesRequest);
		
		ArrayList<NotebookInstanceSummary> userOwnedResources = new ArrayList<NotebookInstanceSummary>();
		ArrayList<NotebookInstanceSummary> notebookSummaryList = (ArrayList<NotebookInstanceSummary>) listNotebookInstancesResult.getNotebookInstances();
		
		for(NotebookInstanceSummary notebook : notebookSummaryList) {
			String arn = notebook.getNotebookInstanceArn();
			ListTagsRequest listTagsRequest = new ListTagsRequest().withResourceArn(arn);
			ListTagsResult listTagsResult = sagemaker.listTags(listTagsRequest);
			ArrayList<Tag> tagList = (ArrayList<Tag>) listTagsResult.getTags();
			for(Tag tags : tagList) {
				System.out.println();
				if(tags.getValue().equals(request.getTagValue())) {
					userOwnedResources.add(notebook);
				}
			}			
		}
		ListInstancesResponse response = new ListInstancesResponse(userOwnedResources);
		return response;
	}
	/*
	public static void main(String[] args) {
		ListInstances listInst = new ListInstances();
		ListInstancesRequest listNIR = new ListInstancesRequest("user","dhoni");
		ListInstancesResponse listInstResp= listInst.handleRequest(listNIR, null);
		System.out.println(listInstResp);
	}
	*/
}
