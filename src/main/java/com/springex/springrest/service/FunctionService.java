package com.springex.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.IContext;

import java.util.HashMap;
public interface FunctionService {
    HashMap<String,String> quadroFunction(Double a,Double b,Double c);
}
