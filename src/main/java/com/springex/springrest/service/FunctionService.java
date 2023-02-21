package com.springex.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.IContext;

import java.util.HashMap;
@Service
public interface FunctionService {
    HashMap<String,String> quadroFunction(Integer a,Integer b,Integer c);

}
