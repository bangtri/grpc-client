package bang.nt.grpc.client.domain.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemParamRes {

    private String code;

    private String value;

    private String type;

    private String description;

    private String createdDate;

    private String modifiedDate;

    private String createdBy;

    private String modifiedBy;

}
