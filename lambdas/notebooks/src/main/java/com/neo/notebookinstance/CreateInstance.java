package com.neo.notebookinstance;


import com.amazonaws.services.sagemaker.*;
import com.amazonaws.services.sagemaker.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.sagemaker.model.Tag;

public class CreateInstance implements RequestHandler<CreateInstanceRequest , String> {
	AmazonSageMaker sagemaker = AmazonSageMakerClientBuilder.standard().withRegion("us-east-1").build();
    
	public String handleRequest(CreateInstanceRequest request, Context context) {

		CreateNotebookInstanceRequest createNotebookInstanceRequest = new CreateNotebookInstanceRequest();
        createNotebookInstanceRequest.setInstanceType(request.getInstanceType());
    	createNotebookInstanceRequest.setNotebookInstanceName(request.getInstanceName());
    	createNotebookInstanceRequest.setLifecycleConfigName(request.LIFECYCLE_CONFIG);
    	createNotebookInstanceRequest.setRoleArn(request.ROLE_ARN);
    	Tag tag = new Tag();
    	tag.setKey(request.getTagKey());
    	tag.setValue(request.getTagValue());
    	
    	createNotebookInstanceRequest.withTags(tag);
		//System.out.println(createNotebookInstanceRequest.getTags());
    	//System.out.println(tag.getKey() + ":" + tag.getValue());
    	
		CreateNotebookInstanceResult createNotebookInstanceResult = sagemaker.createNotebookInstance(createNotebookInstanceRequest);
    	//String result = createNotebookInstanceResult.getNotebookInstanceArn();
 
        return "Creating instance.";
    }
	
	/*public static void main(String[] args) {
		CreateInstanceRequest cir = new CreateInstanceRequest("edgbaston", "ml.t2.medium","user", "kohli");
		CreateInstance cI = new CreateInstance();
		//Context context = new Context();
		cI.handleRequest(cir, null);
	}*/

}
