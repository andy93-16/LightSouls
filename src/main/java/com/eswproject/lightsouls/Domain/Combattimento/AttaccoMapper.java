package com.eswproject.lightsouls.Domain.Combattimento;

public class AttaccoMapper {

    public AttaccoMapper(int pAttacco,int pArma){
        this.posizioneArma=pArma;
        this.posizioneAttacco=pAttacco;
    }

    int posizioneArma;
    int posizioneAttacco;

    public int getPosizioneArma() {
        return posizioneArma;
    }

    public int getPosizioneAttacco() {
        return posizioneAttacco;
    }
}
