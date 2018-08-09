package com.neo.notebookinstance;

import com.amazonaws.services.sagemaker.*;
import com.amazonaws.services.sagemaker.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class DeleteInstance implements RequestHandler<DeleteInstanceRequest , String> {
	AmazonSageMaker sagemaker = AmazonSageMakerClientBuilder.standard().withRegion("us-east-1").build();
    
	public String handleRequest(DeleteInstanceRequest request, Context context) {

		DeleteNotebookInstanceRequest deleteNotebookInstanceRequest = new DeleteNotebookInstanceRequest();

    	deleteNotebookInstanceRequest.setNotebookInstanceName(request.getInstanceName());
		
    	DeleteNotebookInstanceResult deleteNotebookInstanceResult = sagemaker.deleteNotebookInstance(deleteNotebookInstanceRequest);
    	String result = "Deleting instance " + request.getInstanceName();
    	//logger.log("NotebookInstance ARN: " + result);

        
        return result;
    }
	
	public static void main(String[] args) {
		DeleteInstance dI = new DeleteInstance();
		DeleteInstanceRequest dIR = new DeleteInstanceRequest("wrogn");
		dI.handleRequest(dIR, null);
		
	}
	

}
