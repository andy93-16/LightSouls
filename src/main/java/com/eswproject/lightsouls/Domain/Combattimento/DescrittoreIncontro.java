package com.eswproject.lightsouls.Domain.Combattimento;

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
    private List<NemicoWrapper> nemiciWrappers;

    public List<NemicoWrapper> getNemiciWrappers() {
        return nemiciWrappers;
    }

}