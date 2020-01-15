package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoNemico;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggioBase;
import com.eswproject.lightsouls.Domain.Dice.Dice;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.Personaggio.Personaggio;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GestoreIncontro {

    public void setConcluso(boolean concluso) {
        this.concluso = concluso;
    }

    private boolean concluso;

    public Loot generaLoot(StatoPersonaggio statoPersonaggio, int totalEquips, int totalTitanites){

        Loot loot=new Loot();
        Random r = new Random();
        r.nextInt();
        Personaggio personaggio=(Personaggio)statoPersonaggio.getPersonaggioBase();

        for(int i = 0; i<totalEquips; i++)
        {
            loot.getEquipments().add(personaggio.getLootable().get(r.nextInt(personaggio.getLootable().size())));
        }
        int i = 0;
        while (i<totalTitanites)
        {
            loot.getTitanites().add(personaggio.getLootableTitanites().get(r.nextInt(personaggio.getLootableTitanites().size())));
            i++;
        }
        return loot;
    }

    public String Avvia(StatoPersonaggio statoPersonaggio, List<StatoNemico> statoNemici) {
        listaTurni = new LinkedList<>();
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

    public String Schiva(StatoPersonaggio statoPersonaggio) {

        listaTurni.peekFirst().controlloEquip();
        Arma arma=(Arma)listaTurni.peekFirst().getEquipaggiati().get(0);
        statoPersonaggio.schiva(arma.getAttacchi().get(0).getDifficoltaSchivata(),
                       listaTurni.peekFirst().calcolaDanno(0,0));

        return getTurno();
    }


    public String Difendi(StatoPersonaggio statoPersonaggio) {
        listaTurni.peekFirst().controlloEquip();
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
