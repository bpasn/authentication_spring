// package com.spirngauth.authentication_spring;



// import java.net.http.HttpHeaders;

// import org.springframework.core.Ordered;
// import org.springframework.core.annotation.Order;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.converter.HttpMessageNotReadableException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.context.request.WebRequest;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// import com.spirngauth.authentication_spring.models.ApiError;

// @Order(Ordered.HIGHEST_PRECEDENCE)
// @ControllerAdvice
// public class ErrorHandler extends ResponseEntityExceptionHandler {

//     private HttpMessageNotReadableException ex;

//     @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpHeaders headers, HttpStatus status, WebRequest request) {
//        this.ex = ex;
//         String error = "Malformed JSON request";
//        return buildResponseEntity(ApiError(HttpStatus.BAD_REQUEST, error, ex));
//    }

//     private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
//         return new ResponseEntity<>(apiError, apiError.getStatus());
//     }

//     // other exception handlers below

// }
