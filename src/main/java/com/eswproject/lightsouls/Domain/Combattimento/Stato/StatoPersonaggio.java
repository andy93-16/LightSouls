package com.eswproject.lightsouls.Domain.Combattimento.Stato;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Combattimento.AttaccoMapper;
import com.eswproject.lightsouls.Domain.Dice.Dice;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.Personaggio.Personaggio;

import javax.persistence.*;

@Entity
@DiscriminatorValue("StatoPersonaggio")
public class StatoPersonaggio extends StatoPersonaggioBase{


   @Transient
   private int stamina;

   public int getStamina() {
        return stamina;
    }

   public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma=(Arma)getEquipaggiati().get(posizioneArma);
        stamina -= arma.getAttacchi().get(posizioneAttacco).getStaminaCost();
        getEquipaggiatiUsati().add(arma);
        getEquipaggiati().remove(arma);
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
   }

   @Override
   public void attacca(StatoPersonaggioBase statoPersonaggioBase, AttaccoMapper attaccoMapper){

       statoPersonaggioBase.infliggiDanno(
               calcolaDanno(attaccoMapper.getPosArma(),
                       attaccoMapper.getPosAttacco()));
       boolean noWeapons = true;
       for (Equipment eq: this.getEquipaggiati())
       {
           if(eq.getClass().getSimpleName().equals(new Arma().getClass().getSimpleName()))
           {
               noWeapons=false;
               break;
           }
       }
       if(noWeapons){
           getEquipaggiati().addAll(getEquipaggiatiUsati());
           getEquipaggiatiUsati().clear();
           passaTurno();
       }
   }

   public void schiva(int difficoltaSchivata,int danno){
       stamina--;
       if(Dice.getInstance().throw_Dice(DiceColor.GREEN,1)<difficoltaSchivata)
           infliggiDannoPuro(danno);

       passaTurno();
   }

   @Override
   public void passaTurno(){
       setChanged();
       notifyObservers();
   }

   @Override
   public String turno(){
       return "/TurnoPersonaggio";
   }

   @Override
   public void resetStato(){
      this.HP=personaggioBase.getHP_base();
      this.stamina=((Personaggio)personaggioBase).getStamina_base();
      this.dead=false;

   }

}
