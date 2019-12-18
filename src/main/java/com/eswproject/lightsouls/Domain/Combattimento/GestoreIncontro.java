package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Controller.PersonaggioController;
import org.springframework.beans.factory.annotation.Autowired;

public class GestoreIncontro {

    @Autowired
    private PersonaggioController personaggio;

    private static GestoreIncontro obj;

    private GestoreIncontro() {}

    public static GestoreIncontro getInstance()
    {
        if (obj==null)
            obj = new GestoreIncontro();
        return obj;
    }

    public void Init(){}

}
