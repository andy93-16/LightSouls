package com.eswproject.lightsouls.Domain.Combattimento;

import javax.persistence.*;

@Entity
public class NemiciWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Nemico nemico;

    private int numberNemici;

    public Nemico getNemico() {
        return nemico;
    }

    public int getNumberNemici() {
        return numberNemici;
    }




}

