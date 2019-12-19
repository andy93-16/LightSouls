package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggio;

public class StatisticheCombattimentoPersonaggio extends StatisticheCombattimentoBase{

    private int stamina;

    public int getStamina()
    {
        return stamina;
    }

    public void setStamina(int stamina)
    {
        this.stamina = stamina;
    }

    public StatisticheCombattimentoPersonaggio(DescrittorePersonaggio descrittorePersonaggio)
    {
        super(descrittorePersonaggio);
        this.stamina=descrittorePersonaggio.getStamina();

    }


}
