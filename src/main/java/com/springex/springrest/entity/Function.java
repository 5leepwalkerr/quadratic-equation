package com.springex.springrest.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    Integer a;
    Integer b;
    Integer c;
    public Function(String name,Integer a,Integer b,Integer c){
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public  HashMap<String,String> quadro(Integer a,Integer b,Integer c){
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
}


