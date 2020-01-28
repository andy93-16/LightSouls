package com.eswproject.lightsouls.Domain.Stato;

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
        int staminacost= arma.getAttacchi().get(posizioneAttacco).getStaminaCost();
        if(staminacost <= this.getStamina())
        {
            stamina -= staminacost;
            getEquipaggiatiUsati().add(arma);
            getEquipaggiati().remove(arma);
            return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
        }
        else return 0;
   }

   @Override
   public void attacca(StatoPersonaggioBase statoPersonaggioBase, AttaccoMapper attaccoMapper){

       this.danniInflitti = statoPersonaggioBase.infliggiDanno(calcolaDanno(
               attaccoMapper.getPosArma(), attaccoMapper.getPosAttacco()));
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
           resetEquip();
           concludiTurno();
       }
   }

   public void schiva(int difficoltaSchivata,int danno){
       stamina-=((Personaggio)this.personaggioBase).getRollCost();
       if(Dice.getInstance().throw_Dice(DiceColor.GREEN,1)<difficoltaSchivata)
           this.danniSubiti=danno;
           infliggiDannoPuro(danniSubiti);
       concludiTurno();
   }

   @Override
   public void concludiTurno(){
       setChanged();
       notifyObservers();
   }

   @Override
   public String turno()
   {
       return "/TurnoPersonaggio";
   }

   @Override
   public void resetStato(){
      this.HP=personaggioBase.getHP_base();
      this.stamina=((Personaggio)personaggioBase).getStamina_base();
      this.dead=false;
      this.resettaDanni();

   }

   public void regenerateStamina()
   {
       Personaggio p=((Personaggio)this.getPersonaggioBase());
       if((stamina+ p.getStaminaRegen()) >= p.getStamina_base()) stamina=p.getStamina_base();
       else stamina += p.getStaminaRegen();

   }
}
