package bang.nt.grpc.client.controller;


import bang.nt.grpc.client.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public-service")
public class PublicController {

    private final HelloService helloService;

    @RequestMapping(value = "/{message}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> hello(@PathVariable String message) {
        return ResponseEntity.ok(helloService.helloService(message));
    }

}
