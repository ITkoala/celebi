package com.koala.myboot.controller;

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

    @RequestMapping("/get")
    public String get(){
        return "celebi";
    }
}
