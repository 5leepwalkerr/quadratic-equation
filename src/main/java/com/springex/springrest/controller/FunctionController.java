package com.springex.springrest.controller;
import com.springex.springrest.entity.Function;
import com.springex.springrest.repository.FunctionRepository;
import com.springex.springrest.service.FunctionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/quadro")
public class FunctionController {
    @Autowired
    private FunctionService functionService;
    @Autowired
    private FunctionRepository functionRepository;

    @PostMapping("/function")
    public ResponseEntity<?>saveFunction(@RequestBody Function function){
        functionRepository.save(function);
        HashMap<String,String> resultFunction = functionService.quadroFunction(function.getA(),function.getB(), function.getC());
        return new ResponseEntity<>(resultFunction,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?>saveUser(@RequestBody Function function){
      Map<String, Object> map = new HashMap<>();
      map.put("status",1);
      map.put("message","user in saved successfully");
      functionRepository.save(function);
      return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
}
