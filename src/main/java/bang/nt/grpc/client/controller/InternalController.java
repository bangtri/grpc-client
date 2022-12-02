package bang.nt.grpc.client.controller;

import bang.nt.grpc.client.domain.reponse.GlobalRes;
import bang.nt.grpc.client.service.HelloService;
import bang.nt.grpc.client.service.SystemParamService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal-service")
@SecurityRequirement(name = "Security Provider")
public class InternalController {

    private final HelloService helloService;

    private final SystemParamService systemParamService;

    @GetMapping("/{message}")
    public ResponseEntity<?> hello(@PathVariable String message) {
        return ResponseEntity.ok(helloService.helloService(message));
    }

    @GetMapping("/{code}/find-param-by-code")
    public ResponseEntity<GlobalRes<Object>> findParamByCode(@PathVariable @NotBlank String code) {
        return ResponseEntity.ok(systemParamService.findParamByCode(code));
    }

}
