package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggio;

import java.util.Iterator;
import java.util.List;

public class GestoreIncontro {

    private static GestoreIncontro obj;

    private GestoreIncontro() {}

    public static GestoreIncontro getInstance()
    {
        if (obj==null)
            obj = new GestoreIncontro();
        return obj;
    }

    private List<StatisticheCombattimentoBase> statisticheCombattimentoBase;

    private Iterator<StatisticheCombattimentoBase> iterator;

    public void Init(DescrittorePersonaggio personaggio,List<NemicoWrapper> nemiciWrapper) {
    }

}
