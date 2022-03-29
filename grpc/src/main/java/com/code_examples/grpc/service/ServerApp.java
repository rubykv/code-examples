package com.code_examples.grpc.service;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServerApp {
	 public static void main(String[] args) throws IOException, InterruptedException {
	        Server server = ServerBuilder
	                .forPort(8085)
	                .addService(new HelloWorldServiceImpl()).build();
	        server.start();
	        server.awaitTermination();
	    }
}
