package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittoreNemico;

public class StatisticheCombattimentoNemico extends StatisticheCombattimentoBase {

    public StatisticheCombattimentoNemico(DescrittoreNemico descrittoreNemico) {
        super(descrittoreNemico);
    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        return equipaggiati.get(posizioneArma).getAttacchi().get(posizioneAttacco).getDiceRoll();
    }
}