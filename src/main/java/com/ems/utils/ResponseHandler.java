package com.ems.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> response(String message, HttpStatus status, Object responseObj){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", message);
        data.put("code", status.value());
        data.put("data", responseObj);
        return new ResponseEntity<Object>(data, status);
    }

    public static ResponseEntity<Object> response(HttpStatus status, Object responseObj){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", status.name());
        data.put("code", status.value());
        data.put("data", responseObj);
        return new ResponseEntity<Object>(data, status);
    }
}
