package com.eswproject.lightsouls.Domain.Combattimento;

public class StatisticheCombattimentoPersonaggio extends StatisticheCombattimentoBase{

    private int stamina;
    private int staminaRegen;

    public int getStamina()
    {
        return stamina;
    }

    public void setStamina(int stamina)
    {
        this.stamina = stamina;
    }

    public int getStaminaRegen()
    {
        return staminaRegen;
    }

    public void setStaminaRegen(int staminaRegen)
    {
        this.staminaRegen = staminaRegen;
    }

}
