package bang.nt.grpc.client.handler;

import bang.nt.grpc.client.domain.ErrorHandler;
import bang.nt.grpc.client.exeption.EntityNotFoundException;
import bang.nt.grpc.client.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final GenericService genericService;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorHandler<Object>> entityNotFoundException(EntityNotFoundException ex) {
        ErrorHandler<Object> errorHandler = ErrorHandler.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .detail(ex.getDetail())
                .time(new Date())
                .build();
        return new ResponseEntity<>(errorHandler, HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         @NonNull HttpHeaders headers,
                                                                         @NonNull HttpStatus status,
                                                                         @NonNull WebRequest request) {
        String builderMessage = genericService.message("method.is.not.supported") + " " + ex.getMethod() + " "
                + genericService.message("not.supported");
        StringBuilder builderDetail = new StringBuilder();
        builderDetail.append(genericService.message("method.is.supported"));
        builderDetail.append(" ");
        if (!CollectionUtils.isEmpty(ex.getSupportedHttpMethods())) {
            if (ex.getSupportedHttpMethods().size() > 0) {
                ex.getSupportedHttpMethods().forEach(httpMethod -> {
                    builderDetail.append(httpMethod).append(",");
                    builderDetail.deleteCharAt(builderDetail.length() - 1);
                });
            } else {
                ex.getSupportedHttpMethods().forEach(builderDetail::append);
            }
        }
        ErrorHandler<Object> errorHandler = ErrorHandler.builder()
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message(builderMessage)
                .detail(builderDetail)
                .time(new Date())
                .build();
        return new ResponseEntity<>(errorHandler, HttpStatus.OK);
    }

}
