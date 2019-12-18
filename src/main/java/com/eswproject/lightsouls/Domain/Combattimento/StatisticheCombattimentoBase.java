package com.eswproject.lightsouls.Domain.Combattimento;

public class StatisticheCombattimentoBase {

    private int HP_max;
    private int HP;
    private int velocita;

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

    public int getHP_max() {
        return HP_max;
    }

    public void setHP_max(int HP_max) {
        this.HP_max = HP_max;
    }
}
