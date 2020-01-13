package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoNemico;
import com.eswproject.lightsouls.Domain.Personaggio.Nemico;

import javax.persistence.*;

@Entity
public class NemicoWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public StatoNemico getStatoNemico() {
        return statoNemico;
    }

    @OneToOne
    private StatoNemico statoNemico;

    private int numberNemici;

    public int getNumberNemici() {
        return numberNemici;
    }




}

