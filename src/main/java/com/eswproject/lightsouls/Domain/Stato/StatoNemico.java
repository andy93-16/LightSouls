package com.eswproject.lightsouls.Domain.Stato;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("StatoNemico")
public class StatoNemico extends StatoPersonaggioBase implements Cloneable {

    @Override
    public StatoNemico clone() {
        try{
            return (StatoNemico) super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public void attacca(StatoPersonaggioBase statoPersonaggioBase, AttaccoMapper attaccoMapper){
        statoPersonaggioBase.setDanniSubiti(statoPersonaggioBase.infliggiDanno(calcolaDanno(attaccoMapper.getPosAttacco(), attaccoMapper.getPosArma())));

    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma = (Arma)getEquipaggiati().get(posizioneArma);
        getEquipaggiatiUsati().add(arma);
        getEquipaggiati().remove(arma);
        if(getEquipaggiati().isEmpty()){
            resetEquip();
            concludiTurno();
        }
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
    }

    @Override
    public String turno(){
        return "/TurnoNemico";
    }

    @Override
    public void concludiTurno(){
        setChanged();
        notifyObservers();
    }
}

