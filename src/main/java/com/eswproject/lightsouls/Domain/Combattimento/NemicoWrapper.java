package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittoreNemico;

import javax.persistence.*;

@Entity
public class NemicoWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public StatisticheCombattimentoNemico getStatisticheCombattimentoNemico() {
        return statisticheCombattimentoNemico;
    }

    @OneToOne
    private StatisticheCombattimentoNemico statisticheCombattimentoNemico;

    private int numberNemici;

    public int getNumberNemici() {
        return numberNemici;
    }




}

