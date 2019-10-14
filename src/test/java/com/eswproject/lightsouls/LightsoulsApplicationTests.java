package com.eswproject.lightsouls;

import com.eswproject.lightsouls.Domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LightsoulsApplicationTests {

    @Test
    public void contextLoads() {
        Giocatore giocatore = new Giocatore();
        Personaggio personaggio = new Personaggio();
        giocatore.setPersonaggio(personaggio);


       
    }

}
