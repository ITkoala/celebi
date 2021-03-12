package com.koala.myboot.controller;

import com.koala.myboot.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author lsy
 * @date 2021/3/8 20:10
 */
@RestController
public class UserController {

    @Autowired
    private Car car;

    @RequestMapping("/getCar")
    public Car getCar(){
        return car;
    }

    @RequestMapping("/get")
    public String get(){
        return "celebi";
    }
}
