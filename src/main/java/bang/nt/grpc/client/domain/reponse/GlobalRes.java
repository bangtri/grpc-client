package bang.nt.grpc.client.domain.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalRes<T> {

    private int status;

    private String message;

    private T data;

}