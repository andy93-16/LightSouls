package com.eswproject.lightsouls.Domain.Combattimento;

public class StatisticheCombattimentoPersonaggio extends StatisticheCombattimentoBase{




    private int stamina_max;
    private int stamina;
    private int staminaRegen;


    public int getStamina_max() {
        return stamina_max;
    }

    public void setStamina_max(int stamina_max) {
        this.stamina_max = stamina_max;
    }

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
