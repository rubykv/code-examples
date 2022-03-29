package com.code_examples.grpc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: HelloWorld.proto")
public final class HelloWorldServiceGrpc {

  private HelloWorldServiceGrpc() {}

  public static final String SERVICE_NAME = "HelloWorldService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.code_examples.grpc.v1.HelloRequest,
      com.code_examples.grpc.v1.HelloResponse> getExecuteOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteOrder",
      requestType = com.code_examples.grpc.v1.HelloRequest.class,
      responseType = com.code_examples.grpc.v1.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.code_examples.grpc.v1.HelloRequest,
      com.code_examples.grpc.v1.HelloResponse> getExecuteOrderMethod() {
    io.grpc.MethodDescriptor<com.code_examples.grpc.v1.HelloRequest, com.code_examples.grpc.v1.HelloResponse> getExecuteOrderMethod;
    if ((getExecuteOrderMethod = HelloWorldServiceGrpc.getExecuteOrderMethod) == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        if ((getExecuteOrderMethod = HelloWorldServiceGrpc.getExecuteOrderMethod) == null) {
          HelloWorldServiceGrpc.getExecuteOrderMethod = getExecuteOrderMethod =
              io.grpc.MethodDescriptor.<com.code_examples.grpc.v1.HelloRequest, com.code_examples.grpc.v1.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.code_examples.grpc.v1.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.code_examples.grpc.v1.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloWorldServiceMethodDescriptorSupplier("ExecuteOrder"))
              .build();
        }
      }
    }
    return getExecuteOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloWorldServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceStub>() {
        @java.lang.Override
        public HelloWorldServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloWorldServiceStub(channel, callOptions);
        }
      };
    return HelloWorldServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloWorldServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceBlockingStub>() {
        @java.lang.Override
        public HelloWorldServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloWorldServiceBlockingStub(channel, callOptions);
        }
      };
    return HelloWorldServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloWorldServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceFutureStub>() {
        @java.lang.Override
        public HelloWorldServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloWorldServiceFutureStub(channel, callOptions);
        }
      };
    return HelloWorldServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HelloWorldServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void executeOrder(com.code_examples.grpc.v1.HelloRequest request,
        io.grpc.stub.StreamObserver<com.code_examples.grpc.v1.HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExecuteOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.code_examples.grpc.v1.HelloRequest,
                com.code_examples.grpc.v1.HelloResponse>(
                  this, METHODID_EXECUTE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class HelloWorldServiceStub extends io.grpc.stub.AbstractAsyncStub<HelloWorldServiceStub> {
    private HelloWorldServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceStub(channel, callOptions);
    }

    /**
     */
    public void executeOrder(com.code_examples.grpc.v1.HelloRequest request,
        io.grpc.stub.StreamObserver<com.code_examples.grpc.v1.HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HelloWorldServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloWorldServiceBlockingStub> {
    private HelloWorldServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.code_examples.grpc.v1.HelloResponse executeOrder(com.code_examples.grpc.v1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloWorldServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HelloWorldServiceFutureStub> {
    private HelloWorldServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.code_examples.grpc.v1.HelloResponse> executeOrder(
        com.code_examples.grpc.v1.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloWorldServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloWorldServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_ORDER:
          serviceImpl.executeOrder((com.code_examples.grpc.v1.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.code_examples.grpc.v1.HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloWorldServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloWorldServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.code_examples.grpc.v1.HelloWorld.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloWorldService");
    }
  }

  private static final class HelloWorldServiceFileDescriptorSupplier
      extends HelloWorldServiceBaseDescriptorSupplier {
    HelloWorldServiceFileDescriptorSupplier() {}
  }

  private static final class HelloWorldServiceMethodDescriptorSupplier
      extends HelloWorldServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloWorldServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloWorldServiceFileDescriptorSupplier())
              .addMethod(getExecuteOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
