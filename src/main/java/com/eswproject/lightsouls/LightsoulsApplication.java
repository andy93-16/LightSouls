package com.eswproject.lightsouls;

import com.eswproject.lightsouls.Domain.*;
import com.eswproject.lightsouls.Domain.Artifacts.Attacco;
import com.eswproject.lightsouls.Domain.Dice.Dice;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class LightsoulsApplication {

    public static void main(String[] args) {

        SpringApplication.run(LightsoulsApplication.class, args);
//        Dice dice = new Dice();
//        SysIntegertem.out.println(dice.throw_Dice(DiceColor.BLACK,1));

    }

}

