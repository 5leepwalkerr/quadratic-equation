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
    private FunctionRepository functionRepository;

    @PostMapping("/function")
    public ResponseEntity<?>saveFunction(@RequestBody Function function){
        functionRepository.save(function);
        HashMap<String,String> resultFunction = quadro(function.getA(),function.getB(), function.getC());
        return new ResponseEntity<>(resultFunction,HttpStatus.OK);
    }
    public  static HashMap<String,String> quadro(Integer a, Integer b, Integer c){
        HashMap<String,String> resultMap = new HashMap<>();
        Double discriminant =(Math.pow(b,2))-(4*a*c);
        if(discriminant>0){
            Double x1 =  ((-b+Math.sqrt(discriminant))/(2*a)); //First root
            Double x2 =  ((-b-Math.sqrt(discriminant))/(2*a)); // Second root
            if(((a*(Math.pow(x1,2))+(b*x1))+c==0)&&((a*(Math.pow(x2,2)))+(b*x2)+c==0)) {
                resultMap.put("First root is: " + String.format("%.2f", x1), "Second root is: " + String.format("%.2f", x2));
            }
            else if(a*(Math.pow(x1,2))+b*x1+c==0){
                resultMap.put("Only first root in expression: "+String.format("%.2f",x1),"Second root is extraneous!");
            }
            else if(a*(Math.pow(x2,2))+b*x2+c==0){
                resultMap.put("First root is extraneous!","Only second root in expression: "+String.format("%.2f",x2));
            }
            else  throw  new ArithmeticException("Not solved, cuz expression < 0");

        }
        else if(discriminant==0){
            Double x = (double) (-b/(2*a));
                resultMap.put("Only one root! ",String.format("%.3f", x));

        }
        else throw  new ArithmeticException("Expression has no roots!, try another input params");
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
