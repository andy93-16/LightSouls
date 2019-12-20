package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Artifacts.Attacco;
import com.eswproject.lightsouls.Domain.Artifacts.Difesa;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggioBase;


import java.util.List;
import java.util.Observable;

public abstract class StatisticheCombattimentoBase extends Observable implements Comparable<StatisticheCombattimentoBase>  {

    protected int HP;

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

    @Override
    public int compareTo(StatisticheCombattimentoBase statisticheCombattimentoBase){
        return statisticheCombattimentoBase.descrittorePersonaggioBase.getVelocita()-this.descrittorePersonaggioBase.getVelocita();
    }

    protected List<Equipment> equipaggiatiDisponibili;

    public List<Equipment> getEquipaggiatiDisponibili() {
        return equipaggiatiDisponibili;
    }
    protected List<Equipment> equipaggiatiNonDisponibili;

    public List<Equipment> getEquipaggiatiNonDisponibili() {
        return equipaggiatiNonDisponibili;
    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma=(Arma)equipaggiatiDisponibili.get(posizioneArma);
        equipaggiatiNonDisponibili.add(arma);
        equipaggiatiDisponibili.remove(arma);
        if(equipaggiatiDisponibili.isEmpty())
            notifyObservers(this);
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
    }

    public void infliggiDanno(int danno){
        if(HP-danno>0)
            HP=HP-danno;
        else{
            setChanged();
            notifyObservers(this);}
    }

    private int getDifesa(){
        int difesaTot=0;
        for(Equipment equipment: this.equipaggiatiDisponibili){
            for(Difesa difesa : equipment.getDifese())
                difesaTot+=difesa.getDiceRoll();
        }
        for(Equipment equipment: this.equipaggiatiNonDisponibili){
            for(Difesa difesa : equipment.getDifese())
                difesaTot+=difesa.getDiceRoll();
        }
        return difesaTot;
    }




}
