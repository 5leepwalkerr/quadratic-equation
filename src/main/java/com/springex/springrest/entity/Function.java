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
    Long id;
    Integer a,b,c;

    public HashMap<String, String> createEqu(Long a, Long b, Long c) throws ArithmeticException{
        Long discr = (long) ((Math.pow(b,2))-4*(a*c));
        HashMap<String,String> resultMap = new HashMap<>();
        if(discr>0){
            Long x1 =(long) (-b+Math.sqrt(discr))/2*a;
            Long x2 = (long)(-b-Math.sqrt(discr))/2*a;
            resultMap.put("x1",x1.toString());
            resultMap.put("x2",x2.toString());
        }
        else if(discr==0){
            Long x = (long)(-b/2*a);
            resultMap.put("x",x.toString());
        }
        else if(discr<0){
            throw new ArithmeticException("there're no roots!");
        }
        return resultMap;

    }
}
