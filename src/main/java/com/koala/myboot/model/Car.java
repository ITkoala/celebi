package com.koala.myboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO
 *只有在容器中的组件,才会拥有springboot提供的强大功能
 */
//@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
