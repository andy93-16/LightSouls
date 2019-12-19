package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggio;

import java.util.*;

public class GestoreIncontro {

    private static GestoreIncontro obj;

    private GestoreIncontro() {}

    public static GestoreIncontro getInstance()
    {
        if (obj==null)
            obj = new GestoreIncontro();
        return obj;
    }


}
