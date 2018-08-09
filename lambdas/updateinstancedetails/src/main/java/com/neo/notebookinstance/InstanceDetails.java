package com.neo.notebookinstance;



import java.util.ArrayList;
import com.amazonaws.services.sagemaker.*;
import com.amazonaws.services.sagemaker.model.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class InstanceDetails implements RequestHandler<InstanceDetailsRequest , InstanceDetailsResponse> {
	AmazonSageMaker sagemaker = AmazonSageMakerClientBuilder.standard().withRegion("us-east-1").build();
	public InstanceDetailsResponse handleRequest(InstanceDetailsRequest request, Context context) {
		DescribeNotebookInstanceRequest describeNotebookInstanceRequest = new DescribeNotebookInstanceRequest();
		describeNotebookInstanceRequest.setNotebookInstanceName(request.getInstanceName());
		DescribeNotebookInstanceResult describeNotebookResult = sagemaker.describeNotebookInstance(describeNotebookInstanceRequest);
		InstanceDetailsResponse instanceDetailsResponse = new InstanceDetailsResponse();
		instanceDetailsResponse.setInstanceName(describeNotebookResult.getNotebookInstanceName());
		instanceDetailsResponse.setInstancestatus(describeNotebookResult.getNotebookInstanceStatus());
		instanceDetailsResponse.setInstanceType(describeNotebookResult.getInstanceType());
		
		return instanceDetailsResponse;
		
	}
}
