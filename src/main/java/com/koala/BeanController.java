package com.koala;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author lsy
 * @date 2021/3/8 20:57
 */
@RestController
public class BeanController {
    @RequestMapping("/handle")
    public String handle(){
        return "celebi";
    }
}
