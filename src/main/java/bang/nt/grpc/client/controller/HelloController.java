package bang.nt.grpc.client.controller;


import bang.nt.grpc.client.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello-service")
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/{message}")
    public ResponseEntity<?> hello(@PathVariable String message) {
        return ResponseEntity.ok(helloService.helloService(message));
    }

}
