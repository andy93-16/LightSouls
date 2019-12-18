package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Combattimento.NemiciWrapper;

import javax.persistence.*;

import java.util.List;

@Entity
public class DescrittoreIncontro
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<NemiciWrapper> nemiciWrappers;

    public List<NemiciWrapper> getNemiciWrappers() {
        return nemiciWrappers;
    }

}