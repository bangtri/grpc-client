package bang.nt.grpc.client.grpcclient;

import grpc.service.hello.HelloRequest;
import grpc.service.hello.HelloResponse;
import grpc.service.hello.HelloServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloGRPCClient {

    @GrpcClient("GRPC-Application")
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public HelloResponse helloService(String message) {
        return helloServiceBlockingStub.helloService(HelloRequest.newBuilder().setRequest(message).build());
    }

}
