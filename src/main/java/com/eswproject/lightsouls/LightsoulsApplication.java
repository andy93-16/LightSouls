package com.eswproject.lightsouls;

import com.eswproject.lightsouls.Domain.*;
import com.eswproject.lightsouls.Domain.Artifacts.Attacco;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LightsoulsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightsoulsApplication.class, args);
        Giocatore giocatore= new Giocatore();
        Personaggio personaggio = new Personaggio();
//
//        Attacco att = new Attacco();
//        att.setDanno(DiceColor.BLACK, 2);
//        att.setDanno(DiceColor.ORANGE, 1);
//
//        for(int i = 0; i < 10; i++)
//        {
//            System.out.println("Total DMG = " + att.getDanno());
//        }

    }
}

