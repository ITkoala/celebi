package com.koala.myboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybootApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MybootApplication.class, args);
        SpringApplication springApplication = new SpringApplication(MybootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
