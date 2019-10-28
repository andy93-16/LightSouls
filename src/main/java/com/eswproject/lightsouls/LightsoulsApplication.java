package com.eswproject.lightsouls;

import com.eswproject.lightsouls.Domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class LightsoulsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightsoulsApplication.class, args);
        Giocatore giocatore= new Giocatore();
    }
}

