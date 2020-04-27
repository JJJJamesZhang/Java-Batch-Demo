package com.company.demojavabatch.aop;

import com.company.demojavabatch.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result> exceptionGet(Exception e){
        return new ResponseEntity<Result>(new Result("Server Error"), HttpStatus.OK);
    }
}
