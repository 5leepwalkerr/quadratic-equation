package com.springex.springrest.controller;
import com.springex.springrest.entity.Function;
import com.springex.springrest.repository.FunctionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/quadro")
public class FunctionController {
    @Autowired
    private FunctionRepository functionRepository;

    @GetMapping
    public HashMap<String,String> getSolvedFunc(@RequestParam String name,@RequestParam Integer a,@RequestParam Integer b,@RequestParam Integer c) {
        Function firstFunction = new Function(name,a,b,c);
        functionRepository.save(firstFunction);
        return firstFunction.quadro(a,b,c);
    }
}
