package com.code_examples.grpc.client;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order;

import com.code_examples.grpc.v1.HelloRequest;
import com.code_examples.grpc.v1.HelloResponse;
import com.code_examples.grpc.v1.HelloWorldServiceGrpc;
import com.code_examples.grpc.v1.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {
	public static void main(String[] args) {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();

		HelloWorldServiceBlockingStub orderServiceBlockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);

		HelloRequest helloReq = HelloRequest.newBuilder().setGreetings("Hey Foo").build();

		HelloResponse helloResponse = orderServiceBlockingStub.executeOrder(helloReq);

		System.out.println("Received response: " + helloResponse.getInfo());

		managedChannel.shutdown();
	}

}
