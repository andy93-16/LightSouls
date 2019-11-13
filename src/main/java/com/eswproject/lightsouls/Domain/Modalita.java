package com.eswproject.lightsouls.Domain;

import org.springframework.web.bind.annotation.GetMapping;

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

    @OneToMany(fetch = FetchType.EAGER)
    private List<descrittoreDungeon> listaDungeons;

    public List<descrittoreDungeon> getListaDungeons() {
        return listaDungeons;
    }
}