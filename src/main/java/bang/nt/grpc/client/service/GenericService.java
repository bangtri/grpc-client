package bang.nt.grpc.client.service;

import bang.nt.grpc.client.config.MessageTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenericService {

    private final MessageTemplate messageTemplate;

    public String message(String key, String... value) {
        return messageTemplate.message(key, value);
    }

}
