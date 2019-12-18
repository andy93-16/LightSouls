package com.eswproject.lightsouls.Domain.Combattimento;

public class StatisticheCombattimento{

    private int HP;
    private int velocita;
    private int stamina;
    private int staminaRegen;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getVelocita() {
        return velocita;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
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
