package bang.nt.grpc.client.controller;


import bang.nt.grpc.client.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
