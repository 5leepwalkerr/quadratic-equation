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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String userName;
    Integer a;
    Integer b;
    Integer c;
    public Function(String userName,Integer a,Integer b,Integer c){
        this.userName = userName;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}


