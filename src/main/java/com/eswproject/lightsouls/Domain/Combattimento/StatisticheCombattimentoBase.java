package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittorePersonaggioBase;

public class StatisticheCombattimentoBase {

    private int HP;

    private DescrittorePersonaggioBase descrittorePersonaggioBase;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public DescrittorePersonaggioBase getPersonaggio() {
        return descrittorePersonaggioBase;
    }

    public void setPersonaggio(DescrittorePersonaggioBase descrittorePersonaggioBase) {
        this.descrittorePersonaggioBase = descrittorePersonaggioBase;
    }


}
