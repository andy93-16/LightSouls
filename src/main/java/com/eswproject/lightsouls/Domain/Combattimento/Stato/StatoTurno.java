package com.eswproject.lightsouls.Domain.Combattimento.Stato;

import com.eswproject.lightsouls.Controller.IncontroController;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;

public abstract class StatoTurno {

    IncontroController incontroController;

    StatoTurno(IncontroController incontroController){
        this.incontroController=incontroController;
    }

    public abstract String attacca(int posizioneNemico, AttaccoMapper attaccoMapper);

    public abstract String getStatoTurno();

    public abstract String passaTurno();
}
