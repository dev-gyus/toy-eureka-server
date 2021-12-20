package com.example.remindcloudgateway.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ConfigTestController {
    private final Environment env;
//
    @GetMapping("hello")
    public ResponseEntity<String> hello(){
        String hello = "헬로 메소드 진입";
        log.info(hello);
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<String>> getConfigs(){
        return new ResponseEntity<>(Arrays.asList(env.getProperty("test.token-expire"), env.getProperty("test.salt")), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> returnString(@RequestBody String inputString){
        return new ResponseEntity<>(inputString, HttpStatus.OK);
    }
}
