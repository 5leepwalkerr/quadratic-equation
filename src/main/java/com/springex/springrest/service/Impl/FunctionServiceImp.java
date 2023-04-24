package com.springex.springrest.service.Impl;

import com.springex.springrest.service.FunctionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class FunctionServiceImp implements FunctionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionServiceImp.class);

    @Override
    public HashMap<String, String> quadroFunction(Double a, Double b, Double c) {
        HashMap<String,String> resultMap = new HashMap<>();
        Double discriminant =(Math.pow(b,2))-(4*a*c);

        if(discriminant>0){
            Double root1 =  ((-b+Math.sqrt(discriminant))/(2*a)); //First root
            Double root2 =  ((-b-Math.sqrt(discriminant))/(2*a)); // Second root
            if(((a*(Math.pow(root1,2))+(b*root1))+c==0) && ((a*(Math.pow(root2,2)))+(b*root2)+c==0)) {
                resultMap.put("First root is: " + String.format("%.2f", root1), "Second root is: " + String.format("%.2f", root2));
                LOGGER.info("Expression solved!");
            }
            else if(a*(Math.pow(root1,2))+b*root1+c==0){
                resultMap.put("Only first root in expression: "+String.format("%.2f",root1),"Second root is extraneous!");
                LOGGER.info("Expression solved!");
            }
            else if(a*(Math.pow(root2,2))+b*root2+c==0){
                resultMap.put("First root is extraneous!","Only second root in expression: "+String.format("%.2f",root2));
                LOGGER.info("Expression solved!");
            }
            else{
                LOGGER.error("Expression cannot be solved!");
                throw  new ArithmeticException("Not solved, cuz expression < 0");
            }
        }
        else if(discriminant==0){
            Double x = (-b/(2*a));
            resultMap.put("Only one root! ",String.format("%.3f", x));

        }
        else throw new ArithmeticException("Expression has no roots!, try another input params");

        return resultMap;
    }
}
