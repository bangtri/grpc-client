package bang.nt.grpc.client.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandler<T> {

    private Integer status;

    private String message;

    private T detail;

    private Date time;

}
