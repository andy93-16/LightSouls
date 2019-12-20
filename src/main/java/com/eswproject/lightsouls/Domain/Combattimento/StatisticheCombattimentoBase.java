package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.*;
import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggioBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.List;
import java.util.Observable;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class StatisticheCombattimentoBase extends Observable implements Comparable<StatisticheCombattimentoBase> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Transient
    protected int HP;

    @OneToOne
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

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    protected List<Equipment> equipaggiati;

    public List<Equipment> getEquipaggiati() {
        return equipaggiati;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Equipment> equipaggiatiUsati;

    public List<Equipment> getEquipaggiatiUsati() {
        return equipaggiatiUsati;
    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Equipment arma=equipaggiati.get(posizioneArma);
        getEquipaggiatiUsati().add(arma);
        getEquipaggiati().remove(arma);
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
    public int compareTo(StatisticheCombattimentoBase statisticheCombattimentoBase){
       return descrittorePersonaggioBase.getVelocita()-
               statisticheCombattimentoBase.getDescrittorePersonaggioBase().getVelocita();
    }

    public void resetEquipaggiati(){
        equipaggiati.addAll(equipaggiatiUsati);
        equipaggiatiUsati.clear();
    }



}
