package com.springex.springrest.controller;
import com.springex.springrest.entity.Function;
import com.springex.springrest.repository.FunctionRepository;
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
    private FunctionRepository functionRepository;

    @PostMapping("/function")
    public ResponseEntity<?>saveFunction(@RequestBody Function function){
        functionRepository.save(function);
        HashMap<String,String> resultFunction = quadro(function.getA(),function.getB(), function.getC());
        return new ResponseEntity<>(resultFunction,HttpStatus.OK);
    }

    public static HashMap<String,String> quadro(Integer a,Integer b,Integer c){
        HashMap<String,String> resultMap = new HashMap<>();
        Integer discriminant = (int)Math.pow(b,2)-4*(a*c);
        if(discriminant>0){
            Double x1 =  (-b+Math.sqrt(discriminant)/2*a);
            Double x2 =  (-b-Math.sqrt(discriminant)/2*a);
            if(Math.pow(x1,2)*a+b*x1+c==0) {
                resultMap.put("First root is: " + String.format("%.1f", x1), "Second root is: " + String.format("%.1f", x2));
            }
            else if(Math.pow(x2,2)*a+b*x2+c==0){
                resultMap.put("First root is: " + String.format("%.1f", x1), "Second root is: " + String.format("%.1f", x2));
            }
            else  throw  new ArithmeticException("Not solved, cuz instance < 0");

        }
        else if(discriminant==0){
            Double x = (double) (-b/2*a);
            if(Math.pow(x,2)*a+b*x+c==0) {
                resultMap.put("Only one root! ",String.format("%.1f", x));
            }
            else throw  new ArithmeticException("Not solved, cuz instance !=0");

        }
        else throw  new ArithmeticException("Not solved");
        return resultMap;
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
