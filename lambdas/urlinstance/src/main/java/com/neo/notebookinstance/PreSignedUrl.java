package com.neo.notebookinstance;


import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sagemaker.*;
import com.amazonaws.services.sagemaker.model.*;
import com.amazonaws.services.sagemaker.model.CreatePresignedNotebookInstanceUrlRequest;
import com.amazonaws.services.sagemaker.model.CreatePresignedNotebookInstanceUrlResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class PreSignedUrl implements RequestHandler<StartInstanceRequest , StartInstanceResponse> {
	AmazonSageMaker sagemaker = AmazonSageMakerClientBuilder.standard().withRegion("us-east-1").build();
    
	public StartInstanceResponse handleRequest(StartInstanceRequest request, Context context) {
		
		LambdaLogger logger = context.getLogger();
		
		logger.log("Received :" + request.toString());    	
		DescribeNotebookInstanceRequest describeNotebookInstanceRequest = new DescribeNotebookInstanceRequest();
    	describeNotebookInstanceRequest.setNotebookInstanceName(request.getInstanceName());		
    	
    	DescribeNotebookInstanceResult describeNotebookInstanceResult = sagemaker.describeNotebookInstance(describeNotebookInstanceRequest);        
    	
    	boolean notebookActive=describeNotebookInstanceResult.getNotebookInstanceStatus().equals("InService");
    	
    	if(!notebookActive) {
    		String message="Requested Notebook is in " + describeNotebookInstanceResult.getNotebookInstanceStatus() + ". Please start the instance first if status is Stopped or retry in some time it is in pending state";
    		StartInstanceResponse startInstanceResponse = new StartInstanceResponse("",message);
    		return startInstanceResponse;
    	}
    	    	
    	CreatePresignedNotebookInstanceUrlRequest preSignedUrlRequest = new CreatePresignedNotebookInstanceUrlRequest();
	    preSignedUrlRequest.setNotebookInstanceName(request.getInstanceName());
	    String url = sagemaker.createPresignedNotebookInstanceUrl(preSignedUrlRequest).getAuthorizedUrl();
	    StartInstanceResponse startInstanceResponse = new StartInstanceResponse(url,"");
	    return startInstanceResponse;
	}

}
