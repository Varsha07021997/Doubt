package com.restful.webservices.restfulwebservices.Controller;
import com.restful.webservices.restfulwebservices.Bean.ExceptionBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object>handleAllException(Exception ex, WebRequest request)
    {
        ExceptionBean exceptionBean=new ExceptionBean(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<Object>handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request)
    {
        ExceptionBean exceptionBean=new ExceptionBean(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionBean, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ExceptionBean exceptionBean=new ExceptionBean(new Date(),ex.getMessage(),ex.getBindingResult().toString());
        return new ResponseEntity(exceptionBean, HttpStatus.BAD_REQUEST);
    }

}
