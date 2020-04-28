package com.company.demojavabatch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @RequestMapping(value = "loginError")
    public ResponseEntity error(){
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
