package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Stato.StatoNemico;
import com.eswproject.lightsouls.Domain.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Stato.StatoPersonaggioBase;
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

    public Loot generaLoot(StatoPersonaggio statoPersonaggio, int totalEquips, int totalTitanites, int totalanime){

        Loot loot=new Loot();
        Random r = new Random();
        r.nextInt();
        Personaggio personaggio=(Personaggio)statoPersonaggio.getPersonaggioBase();

        for(int i = 0; i<totalEquips; i++)
        {
            loot.getEquipments().add(personaggio.getLootable().get(r.nextInt(personaggio.getLootable().size())));
        }

        for (int i=0; i<totalTitanites; i++)
        {
            loot.getTitanites().add(personaggio.getLootableTitanites().get(r.nextInt(personaggio.getLootableTitanites().size())));
        }

        loot.setAnime(totalanime);

        return loot;
    }

    public String Avvia(StatoPersonaggio statoPersonaggio, List<StatoNemico> statoNemici) {
        listaTurni = new LinkedList<>();
        listaTurni.add(statoPersonaggio);
        listaTurni.addAll(statoNemici);
        Collections.sort(listaTurni);
        return getTurno();
    }

    public String PassaTurno(){
        listaTurni.peekFirst().resetEquip();
        listaTurni.peekFirst().resettaDanni();
        return this.ConcludiTurno();
    }

    public String ConcludiTurno() {
        listaTurni.offerLast(listaTurni.pollFirst());
        while(listaTurni.peekFirst().isDead())
            listaTurni.offerLast(listaTurni.pollFirst());
        if(listaTurni.peekFirst().getClass().getSimpleName().equals((new StatoPersonaggio()).getClass().getSimpleName()))
        {
            ((StatoPersonaggio)listaTurni.peekFirst()).regenerateStamina();
        }
        return getTurno();
    }

    public String Attacca(int posizioneNemico,AttaccoMapper attaccoMapper) {
        listaTurni.peekFirst().attacca(
                listaTurni.get(posizioneNemico), attaccoMapper);
        return getTurno();
    }

    public String Schiva(StatoPersonaggio statoPersonaggio) {
        statoPersonaggio.resettaDanni();
        if(statoPersonaggio.getStamina() >= ((Personaggio)statoPersonaggio.getPersonaggioBase()).getRollCost())
        {
            Arma arma = (Arma) listaTurni.peekFirst().getEquipaggiati().get(0);
            statoPersonaggio.schiva(arma.getAttacchi().get(0).getDifficoltaSchivata(),
                    listaTurni.peekFirst().calcolaDanno(0, 0));

            return getTurno();
        }
        else return Difendi(statoPersonaggio);
    }


    public String Difendi(StatoPersonaggio statoPersonaggio) {
        statoPersonaggio.resettaDanni();
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
