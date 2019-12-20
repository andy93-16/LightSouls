package com.eswproject.lightsouls.Domain.Combattimento.Stato;


import com.eswproject.lightsouls.Controller.IncontroController;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;

public class TurnoPersonaggio extends StatoTurno {

   public TurnoPersonaggio(IncontroController incontroController){
       super(incontroController);
   }

   @Override
   public String attacca(int posizioneNemico, AttaccoMapper attaccoMapper){
       this.incontroController.getListaTurni().get(posizioneNemico).
               infliggiDanno(this.incontroController.getStatisticheCombattimentoPersonaggio().
                       calcolaDanno(attaccoMapper.getPosizioneArma(),attaccoMapper.getPosizioneAttacco()));
       if(this.incontroController.getStatisticheCombattimentoPersonaggio().getEquipaggiati().isEmpty()){
           this.incontroController.getStatisticheCombattimentoPersonaggio().resetEquipaggiati();
           return this.incontroController.PassaTurno();
       }
       else
       return "TurnoPersonaggio";
   }

   @Override
   public String passaTurno(){
       return this.incontroController.PassaTurno();
   }

   @Override
   public String getStatoTurno(){
       return "/TurnoPersoanggio";
   }
}
