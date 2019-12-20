package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.*;
import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggioBase;


import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class StatisticheCombattimentoBase extends Observable implements Observer {

    protected int HP;

    protected StatoCombattente statoCombattente;

    protected DescrittorePersonaggioBase descrittorePersonaggioBase;

    public int getHP() {
        return HP;
    }


    public DescrittorePersonaggioBase getDescrittorePersonaggioBase() {
        return descrittorePersonaggioBase;
    }

    public StatisticheCombattimentoBase(DescrittorePersonaggioBase descrittorePersonaggioBase){
        this.descrittorePersonaggioBase=descrittorePersonaggioBase;
        this.HP=descrittorePersonaggioBase.getHP();
    }


    protected List<Equipment> equipaggiati;

    public List<Equipment> getEquipaggiati() {
        return equipaggiati;
    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma=(Arma)equipaggiati.get(posizioneArma);
        if(equipaggiati.isEmpty())
            notifyObservers(this);
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
    }

    public void infliggiDanno(int danno){
        if(HP-danno>0)
            HP=HP-danno;
        else{}
    }

    private int getDifesa() {
        int difesaTot = 0;
        for (Equipment equipment : this.equipaggiati) {
            for (Difesa difesa : equipment.getDescrittoreEquipment().getDifese())
                difesaTot += difesa.getDiceRoll();
        }
        for (Equipment equipment : this.equipaggiati) {
            for (Difesa difesa : equipment.getDescrittoreEquipment().getDifese())
                difesaTot += difesa.getDiceRoll();
        }
        return difesaTot;
    }

    @Override
    public void update(Observable equipment,boolean used){

    }



}
