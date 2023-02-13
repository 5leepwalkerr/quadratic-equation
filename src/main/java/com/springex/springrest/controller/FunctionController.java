package com.springex.springrest.controller;


import com.springex.springrest.entity.Function;
import com.springex.springrest.repository.FunctionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@Slf4j
@RestController
@RequestMapping("/quadro")

public class FunctionController {

    @Autowired
    private FunctionRepository functionRepository;


    @GetMapping("/calculate")
    public HashMap<?,?> getData(@RequestParam(name = "a") Long a,@RequestParam(name = "b")Long b,@RequestParam(name = "c")Long c){
        Function function = new Function();

        return function.createEqu(a,b,c);
    }
    /* @PostMapping("/calculate/{a}/{b}/{c}")
    public ResponseEntity<Function> saveFunc(){

    }
    */

}
