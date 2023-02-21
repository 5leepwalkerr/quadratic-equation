package com.springex.springrest.service.Impl;

import com.springex.springrest.service.FunctionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FunctionServiceImp implements FunctionService {
    @Override
    public HashMap<String, String> quadroFunction(Double a, Double b, Double c) {
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
}
