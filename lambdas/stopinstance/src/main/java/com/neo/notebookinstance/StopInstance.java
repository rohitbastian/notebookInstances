package com.neo.notebookinstance;

import com.amazonaws.services.sagemaker.*;
import com.amazonaws.services.sagemaker.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class StopInstance implements RequestHandler<StopInstanceRequest , StopInstanceResponse> {
	AmazonSageMaker sagemaker = AmazonSageMakerClientBuilder.standard().withRegion("us-east-1").build();
    
	public StopInstanceResponse handleRequest(StopInstanceRequest request, Context context) {
		
		//LambdaLogger logger = context.getLogger();
		
		//logger.log("Received :" + request.toString());    	
		
    	StopNotebookInstanceRequest stopNotebookInstanceRequest = new StopNotebookInstanceRequest();
        stopNotebookInstanceRequest.setNotebookInstanceName(request.getInstanceName());
		
    	StopNotebookInstanceResult stopNotebookInstanceResult = sagemaker.stopNotebookInstance(stopNotebookInstanceRequest);
    	//String result = stopNotebookInstanceResult.toString();
    	//logger.log("NotebookInstance ARN: " + result);
    	DescribeNotebookInstanceRequest describeNotebookInstanceRequest = new DescribeNotebookInstanceRequest();
    	describeNotebookInstanceRequest.setNotebookInstanceName(request.getInstanceName());
    	
    	DescribeNotebookInstanceResult describeNotebookInstanceResult = sagemaker.describeNotebookInstance(describeNotebookInstanceRequest);
    	
    	return new StopInstanceResponse("Stopping of instance is" + describeNotebookInstanceResult.getNotebookInstanceStatus() + ". This might take a while");
	}

	public static void main(String[] args) {
		StopInstanceRequest req = new StopInstanceRequest("t20wc");
		StopInstance sInst = new StopInstance();
		//System.out.println(sInst.handleRequest(req, null));
		
		//StopNotebookInstanceRequest stopNotebookInstanceRequest = new StopNotebookInstanceRequest("t20wc");
	}

}
