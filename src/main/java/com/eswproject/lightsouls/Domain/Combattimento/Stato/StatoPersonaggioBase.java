package com.eswproject.lightsouls.Domain.Combattimento.Stato;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Difesa;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;
import com.eswproject.lightsouls.Domain.Personaggio.PersonaggioBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Observable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class StatoPersonaggioBase extends Observable  implements Comparable<StatoPersonaggioBase>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getHP() {
        return HP;
    }

    public boolean isDead() {
        return dead;
    }

    @Transient
    protected boolean dead = false;

    @Transient
    protected int HP;

    public PersonaggioBase getPersonaggioBase() {
        return personaggioBase;
    }

    public void setPersonaggioBase(PersonaggioBase personaggioBase) {
        this.personaggioBase = personaggioBase;
    }

    @OneToOne
    protected PersonaggioBase personaggioBase;

    public abstract void attacca(StatoPersonaggioBase statoPersonaggioBase, AttaccoMapper attaccoMapper);

    public abstract String turno();

    public void passaTurno()
    {
        setChanged();
        notifyObservers();
    }

    public void infliggiDanno(int danno){
        int dannofin=danno-getDifesa();
        if(dannofin>0)
            HP=HP-dannofin;
        if(HP<=0){
            HP=0;
            dead=true;
            setChanged();
            notifyObservers();
        }
    }

    public void infliggiDannoPuro(int danno){

        if(danno>0)
            HP=HP-danno;
        if(HP<=0){
            HP=0;
            dead=true;
            setChanged();
            notifyObservers();
        }
    }


    public abstract int calcolaDanno(int posizioneArma,int posizioneAttacco);

    private int getDifesa() {
        int difesaTot = 0;
        for (Equipment equipment : getEquipaggiati()) {
            for (Difesa difesa : equipment.getDifese())
                difesaTot += difesa.getDiceRoll();
        }
        for (Equipment equipment : getEquipaggiati()) {
            for (Difesa difesa : equipment.getDifese())
                difesaTot += difesa.getDiceRoll();
        }
        return difesaTot;
    }

    @Override
    public int compareTo(StatoPersonaggioBase statoPersonaggioBase){
        return statoPersonaggioBase.personaggioBase.getVelocita_base()-
                this.personaggioBase.getVelocita_base();
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

    public void resetStato(){
        this.HP=personaggioBase.getHP_base();
    }

}
