package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggio;

public class StatisticheCombattimentoPersonaggio extends StatisticheCombattimentoBase{

    private int stamina;

    public int getStamina()
    {
        return stamina;
    }


    public StatisticheCombattimentoPersonaggio(DescrittorePersonaggio descrittorePersonaggio)
    {
        super(descrittorePersonaggio);
        this.stamina=descrittorePersonaggio.getStamina();

    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma=(Arma)equipaggiati.get(posizioneArma);
        stamina=stamina-arma.getAttacchi().get(posizioneAttacco).getStaminaCost();
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
    }

    public void resetStatistiche(){
        HP=descrittorePersonaggioBase.getHP();
        DescrittorePersonaggio descrittorePersonaggio=(DescrittorePersonaggio)descrittorePersonaggioBase;
        stamina=descrittorePersonaggio.getStamina();
    }

}
