package com.eswproject.lightsouls.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modalita
{

    @Id
    private String name;

    public String getName()
    {
        return name;
    }

    @OneToMany
    private List<descrittoreDungeon> listaDungeons;

    public List<descrittoreDungeon> getListaDungeons() {
        return listaDungeons;
    }
}