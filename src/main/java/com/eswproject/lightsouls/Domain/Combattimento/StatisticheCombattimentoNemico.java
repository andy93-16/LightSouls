package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;
import com.eswproject.lightsouls.Domain.Personaggio.DescrittoreNemico;

public class StatisticheCombattimentoNemico extends StatisticheCombattimentoBase {

    public StatisticheCombattimentoNemico(DescrittoreNemico descrittoreNemico) {
        super(descrittoreNemico);
    }

    public int calcolaDanno(int posizioneArma,int posizioneAttacco){
        Arma arma=(Arma)equipaggiati.get(posizioneArma);
        return arma.getAttacchi().get(posizioneAttacco).getDiceRoll();
    }
}
