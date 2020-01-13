package com.eswproject.lightsouls.Domain.Combattimento.Stato;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;
import com.eswproject.lightsouls.Domain.Personaggio.Nemico;

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
        statoPersonaggioBase.infliggiDanno(
                calcolaDanno(attaccoMapper.getPosizioneAttacco(),
                        attaccoMapper.getPosizioneArma()));
        if(getEquipaggiati().isEmpty()){
            getEquipaggiati().addAll(getEquipaggiatiUsati());
            getEquipaggiatiUsati().clear();
            passaTurno();
        }
    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma = (Arma)getEquipaggiati().get(posizioneArma);
        getEquipaggiatiUsati().add(arma);
        getEquipaggiati().remove(arma);
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
    }

    @Override
    public String turno(){
        return "/TurnoNemico";
    }
}

