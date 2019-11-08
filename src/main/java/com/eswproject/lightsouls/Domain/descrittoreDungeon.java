package com.eswproject.lightsouls.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class descrittoreDungeon{

    public void setBossName(String bossName) {
        BossName = bossName;
    }

    @Id
    private String BossName;

    public List<descrittoreIncontro> getListaIncontri() {
        return listaIncontri;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<descrittoreIncontro> listaIncontri;

}