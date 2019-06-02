package com.example.demo.controller;

import com.example.demo.model.CommonFeilds;
import com.example.demo.model.Name;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class SampleController {

    @GetMapping(value = "/name")
    public ResponseEntity<?> getName(@RequestHeader HttpHeaders headers, @RequestParam(value = "type", required = false) String type) throws Exception {
        ResponseEntity response;

        // Endpoint sepecific Headers check.
        if (!headers.keySet().containsAll(Arrays.asList("header1", "header2", "header3"))) {
            throw new Exception("Required Headers [header1,header2,header3] Not found !");
        }

        if (("name").equalsIgnoreCase(type)) {
            response = new ResponseEntity(new Name(headers), HttpStatus.OK);
        } else {
            response = new ResponseEntity(new CommonFeilds(headers), HttpStatus.OK);
        }

        return response;
    }
}
