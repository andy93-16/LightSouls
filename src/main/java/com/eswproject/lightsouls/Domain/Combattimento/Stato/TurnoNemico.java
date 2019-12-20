package com.eswproject.lightsouls.Domain.Combattimento.Stato;

import com.eswproject.lightsouls.Controller.IncontroController;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;

public class TurnoNemico extends StatoTurno {

    String TurnoNemico = "/TurnoNemico";
    public TurnoNemico(IncontroController incontroController){
        super(incontroController);
    }

    @Override
    public String attacca(int posizioneNemico, AttaccoMapper attaccoMapper){
        return TurnoNemico;
    }

    @Override
    public String getStatoTurno(){
        return TurnoNemico;
    }

    @Override
    public String passaTurno(){
        return TurnoNemico;
    }
}