package com.shop.spring.myshop;

import com.shop.spring.myshop.service.FileStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.Resource;

@SpringBootApplication
public class MyshopApplication  extends SpringBootServletInitializer implements CommandLineRunner {

    @Resource
    FileStorage fileStorage;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyshopApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileStorage.deleteAll();
        fileStorage.init();
    }
}
