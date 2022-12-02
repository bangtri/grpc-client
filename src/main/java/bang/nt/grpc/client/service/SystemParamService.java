package bang.nt.grpc.client.service;

import bang.nt.grpc.client.domain.reponse.GlobalRes;
import bang.nt.grpc.client.domain.reponse.SystemParamRes;
import bang.nt.grpc.client.grpcclient.SystemParamGRPCClient;
import grpc.service.param.DetailParamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemParamService {

    private final SystemParamGRPCClient systemParamGRPCClient;

    public GlobalRes<Object> findParamByCode(String code) {
        DetailParamResponse response = systemParamGRPCClient.findParamByCode(code);
        GlobalRes<Object> globalRes = GlobalRes.builder()
                .status(response.getResult().getStatus())
                .message(response.getResult().getMessage())
                .build();
        if (response.getResult().getStatus() == HttpStatus.OK.value()) {
            SystemParamRes systemParamRes = SystemParamRes.builder()
                    .code(response.getData().getCode())
                    .value(response.getData().getValue())
                    .type(response.getData().getType())
                    .description(response.getData().getDescription())
                    .createdDate(response.getData().getCreatedDate())
                    .modifiedDate(response.getData().getModifiedDate())
                    .createdBy(response.getData().getCreatedBy())
                    .modifiedBy(response.getData().getModifiedBy())
                    .build();
            globalRes.setData(systemParamRes);
        }
        return globalRes;
    }

}
