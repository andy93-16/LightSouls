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

    @OneToMany(fetch=FetchType.EAGER)
    private List<DescrittoreDungeon> listaDungeons;



    public List<DescrittoreDungeon> getListaDungeons() {
        return listaDungeons;
    }
}