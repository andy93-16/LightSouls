package com.eswproject.lightsouls.Domain.Partita;

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
    private List<DescrittoreDungeon> listaDungeons;

    public List<DescrittoreDungeon> getListaDungeons() {
        return listaDungeons;
    }
}