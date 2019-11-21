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

    @javax.persistence.Transient
    private List<DescrittoreDungeon> listaDungeons;



    public List<DescrittoreDungeon> getListaDungeons() {
        return listaDungeons;
    }
}