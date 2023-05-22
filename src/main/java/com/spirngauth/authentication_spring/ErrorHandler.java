package com.spirngauth.authentication_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.spirngauth.authentication_spring.models.ECode;
import com.spirngauth.authentication_spring.payload.response.MessageResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.ServletException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ControllerAdvice
@Getter
@Setter
@ToString
@Service
public class ErrorHandler extends Exception{
    @ExceptionHandler(value = { Exception.class, AuthenticationException.class, BadCredentialsException.class,
            UsernameNotFoundException.class, AccessDeniedException.class })
    public ResponseEntity<Object> handlerAnyException(Exception ex, WebRequest request) {
        String errorMessageDesc = ex.getLocalizedMessage();
        HttpStatus code = HttpStatus.BAD_REQUEST;
        int status = 200;
        if (errorMessageDesc == null) {
            errorMessageDesc = ex.getMessage();
        }
        if (ex instanceof AuthenticationException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof AccessDeniedException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof BadCredentialsException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof UsernameNotFoundException) {
            errorMessageDesc = ex.getLocalizedMessage();
            code = HttpStatus.BAD_REQUEST;
            status = 400;
        }
        if (ex instanceof IOException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof ServletException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof SignatureException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof MalformedJwtException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof ExpiredJwtException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof UnsupportedJwtException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }
        if (ex instanceof IllegalArgumentException) {
            errorMessageDesc = ex.getLocalizedMessage();
        }

        MessageResponse errorMessage = new MessageResponse(errorMessageDesc, code, status);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
