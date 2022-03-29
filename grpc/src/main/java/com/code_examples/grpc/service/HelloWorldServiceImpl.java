package com.code_examples.grpc.service;

import com.code_examples.grpc.v1.HelloResponse;
import com.code_examples.grpc.v1.HelloWorldServiceGrpc.HelloWorldServiceImplBase;

public class HelloWorldServiceImpl extends HelloWorldServiceImplBase{
	
	 @Override
	    public void executeOrder(com.code_examples.grpc.v1.HelloRequest request,
	            io.grpc.stub.StreamObserver<com.code_examples.grpc.v1.HelloResponse> responseObserver) {
	 
		 HelloResponse response = HelloResponse.newBuilder()
	                                                          .setInfo(request.getGreetings())
	                                                          .build();
	 
	        responseObserver.onNext(response);
	        responseObserver.onCompleted();
	    }

}
