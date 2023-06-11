package com.spirngauth.authentication_spring.config;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.http.HttpHeaders;
import java.sql.SQLException;
import java.util.Date;

import com.spirngauth.authentication_spring.models.ErrorDetail;
import com.spirngauth.authentication_spring.payload.response.ResourceNotFoundExecption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spirngauth.authentication_spring.models.ApiError;
import com.spirngauth.authentication_spring.models.ErrorResponse;
import com.spirngauth.authentication_spring.payload.response.BaseResponse;

import javax.naming.AuthenticationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorHandler {
    private static Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    //THROW ERROR OLD
    /*@ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(
        Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage()
            ),
            status
        );
    }

    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(
        Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

    // converting the stack trace to String
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    e.printStackTrace(printWriter);
    // String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage()
            //   stackTrace // specifying the stack trace in case of 500s
            ),
            status
        );
    }*/

    //NEW THROW ERROR
    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundExecption.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundExecption exception,
                                                                       WebRequest webRequest){
        ErrorDetail errorDetails = new ErrorDetail(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(.class)
//    public ResponseEntity<ErrorDetail> handleBlogAPIException(AuthenticationException exception,
//                                                               WebRequest webRequest){
//        ErrorDetail errorDetails = new ErrorDetail(new Date(), exception.getMessage(),
//                webRequest.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }
    // global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGlobalException(Exception exception,WebRequest webRequest){
        ErrorDetail errorDetails = new ErrorDetail(new Date(), NestedExceptionUtils.getMostSpecificCause(exception).getMessage(),
                webRequest.getDescription(false));
            logger.info(NestedExceptionUtils.getMostSpecificCause(exception).getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
