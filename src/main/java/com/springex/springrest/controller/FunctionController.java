package com.springex.springrest.controller;
import com.springex.springrest.entity.Function;
import com.springex.springrest.repository.FunctionRepository;
import com.springex.springrest.service.FunctionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/quadro")
public class FunctionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionController.class);
    @Autowired
    private FunctionService functionService;
    @Autowired
    private FunctionRepository functionRepository;

    @PostMapping("/function")
    public ResponseEntity<?>saveFunction(@RequestBody Function function) {
        functionRepository.save(function);
        HashMap<String, String> resultFunction = functionService.quadroFunction(function.getA(), function.getB(), function.getC());
        LOGGER.info("Recieved POST request to '/function' with params: {}, {}, {}",function.getA(),function.getB(),function.getC());
        return new ResponseEntity<>(resultFunction, HttpStatus.OK);
    }
}
