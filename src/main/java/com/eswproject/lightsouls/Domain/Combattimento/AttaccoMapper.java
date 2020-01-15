package com.eswproject.lightsouls.Domain.Combattimento;

public class AttaccoMapper {

    public AttaccoMapper(int posArma,int posAttacco){
        this.posArma=posArma;
        this.posAttacco=posAttacco;
    }
    int posArma;
    int posAttacco;

    public int getPosArma() {
        return posArma;
    }

    public int getPosAttacco() {
        return posAttacco;
    }
}
