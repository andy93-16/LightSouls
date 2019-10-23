package com.eswproject.lightsouls;

import com.eswproject.lightsouls.Domain.Giocatore;
import com.eswproject.lightsouls.Domain.Personaggio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LightsoulsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightsoulsApplication.class, args);
        Giocatore giocatore= new Giocatore();

    }

}

