package bang.nt.grpc.client.service;

import bang.nt.grpc.client.domain.reponse.GlobalRes;
import bang.nt.grpc.client.grpcclient.HelloGRPCClient;
import grpc.service.hello.HelloResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloGRPCClient helloGRPCClient;

    public GlobalRes<Object> helloService(String message) {
        HelloResponse response = helloGRPCClient.helloService(message);
        return GlobalRes.builder()
                .status(Integer.parseInt(response.getStatus()))
                .message(response.getMessage())
                .data(response.getResponse())
                .build();
    }

}
