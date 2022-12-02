package bang.nt.grpc.client.grpcclient;

import grpc.service.param.DetailParamRequest;
import grpc.service.param.DetailParamResponse;
import grpc.service.param.SystemParamServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class SystemParamGRPCClient {

    @GrpcClient("GRPC-Server")
    SystemParamServiceGrpc.SystemParamServiceBlockingStub systemParamServiceBlockingStub;

    public DetailParamResponse findParamByCode(String code) {
        return systemParamServiceBlockingStub.findParamByCode(DetailParamRequest.newBuilder().setCode(code).build());
    }

}
