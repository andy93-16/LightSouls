package com.eswproject.lightsouls.Domain.Combattimento;

import javax.persistence.*;

import java.util.List;

@Entity
public class DescrittoreIncontro
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int lootablesEquip;

    private int lootableTitanites;

    private int lootableAnime;

    public int getId() {
        return id;
    }

    public List<NemicoMapper> getNemicoMapper() {
        return nemicoMapper;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<NemicoMapper> nemicoMapper;

    public int getLootablesEquip() {
        return lootablesEquip;
    }

    public int getLootableTitanites() {
        return lootableTitanites;
    }

    public int getLootableAnime() {
        return lootableAnime;
    }
}