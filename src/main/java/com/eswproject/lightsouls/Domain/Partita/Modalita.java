package com.eswproject.lightsouls.Domain.Partita;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modalita
{
    @Id
    private String name;

    @OneToMany
    private List<DescrittoreDungeon> listaDungeons;

    public String getName()
    {
        return name;
    }

    public List<DescrittoreDungeon> getListaDungeons() {
        return listaDungeons;
    }
}