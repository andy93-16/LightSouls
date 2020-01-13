package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoNemico;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggioBase;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GestoreIncontro {

    public void setConcluso(boolean concluso) {
        this.concluso = concluso;
    }

    private boolean concluso;

    private Loot loot;

    public void generaLoot(){



    }

    public String Avvia(StatoPersonaggio statoPersonaggio, List<StatoNemico> statoNemici) {
        listaTurni= new LinkedList<>();
        listaTurni.add(statoPersonaggio);
        listaTurni.addAll(statoNemici);
        Collections.sort(listaTurni);
        return getTurno();
    }

    public String PassaTurno() {
        listaTurni.offerLast(listaTurni.pollFirst());
        while(listaTurni.peekFirst().isDead())
            listaTurni.offerLast(listaTurni.pollFirst());
        return getTurno();
    }

    public String Attacca(int posizioneNemico,AttaccoMapper attaccoMapper) {
        listaTurni.peekFirst().attacca(
                listaTurni.get(posizioneNemico), attaccoMapper);
        return getTurno();
    }

    public String Difendi(StatoPersonaggio statoPersonaggio) {
        listaTurni.peekFirst().attacca(statoPersonaggio, new AttaccoMapper(0, 0));
        return getTurno();
    }

    private LinkedList<StatoPersonaggioBase> listaTurni;

    public LinkedList<StatoPersonaggioBase> getListaTurni(){
        return listaTurni;
    }

    public String getTurno(){
        if(concluso)
            return "/RisultatoIncontro";
        else
            return listaTurni.peekFirst().turno();
    }

}
