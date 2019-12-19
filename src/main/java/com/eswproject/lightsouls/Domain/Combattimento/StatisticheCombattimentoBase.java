package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggioBase;

import java.util.Comparator;

public class StatisticheCombattimentoBase implements Comparable<StatisticheCombattimentoBase> {

    private int HP;

    protected DescrittorePersonaggioBase descrittorePersonaggioBase;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public DescrittorePersonaggioBase getDescrittorePersonaggioBase() {
        return descrittorePersonaggioBase;
    }

    public void setDescrittorePersonaggioBase(DescrittorePersonaggioBase descrittorePersonaggioBase) {
        this.descrittorePersonaggioBase = descrittorePersonaggioBase;
    }

    public StatisticheCombattimentoBase(DescrittorePersonaggioBase descrittorePersonaggioBase){
        this.descrittorePersonaggioBase=descrittorePersonaggioBase;
        this.HP=descrittorePersonaggioBase.getHP();
    }

    @Override
    public int compareTo(StatisticheCombattimentoBase statisticheCombattimentoBase){
        return statisticheCombattimentoBase.descrittorePersonaggioBase.getVelocita()-this.descrittorePersonaggioBase.getVelocita();
    }




}
