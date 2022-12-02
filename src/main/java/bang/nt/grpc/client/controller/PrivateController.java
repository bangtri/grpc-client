package bang.nt.grpc.client.controller;

import bang.nt.grpc.client.service.HelloService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/private-service")
@SecurityRequirement(name = "Security Provider")
public class PrivateController {

    private final HelloService helloService;

    @GetMapping("/{message}")
    public ResponseEntity<?> hello(@PathVariable String message) {
        return ResponseEntity.ok(helloService.helloService(message));
    }

}
