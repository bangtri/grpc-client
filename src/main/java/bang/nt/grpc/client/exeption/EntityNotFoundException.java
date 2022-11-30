package bang.nt.grpc.client.exeption;

import java.io.IOException;

public class EntityNotFoundException extends IOException {

    private final Object detail;

    public EntityNotFoundException(String message, Object detail) {
        super(message);
        this.detail = detail;
    }

    public Object getDetail() {
        return detail;
    }

}
