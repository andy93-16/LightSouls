package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Personaggio.DescrittoreNemico;

import javax.persistence.*;

@Entity
public class NemicoWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private DescrittoreNemico descrittoreNemico;

    private int numberNemici;

    public DescrittoreNemico getDescrittoreNemico() {
        return descrittoreNemico;
    }

    public int getNumberNemici() {
        return numberNemici;
    }




}

