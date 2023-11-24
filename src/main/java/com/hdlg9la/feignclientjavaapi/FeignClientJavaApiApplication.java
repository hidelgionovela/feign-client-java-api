package com.hdlg9la.feignclientjavaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // habilitando o uso do FeignClients
public class FeignClientJavaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientJavaApiApplication.class, args);
    }

}
