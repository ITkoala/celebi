package com.koala.myboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author lsy
 * @date 2021/2/5 10:47
 */
@RestController
public class UserController {
    @RequestMapping(value = "/get")
    public String get (){
        return "12";
    }
}
