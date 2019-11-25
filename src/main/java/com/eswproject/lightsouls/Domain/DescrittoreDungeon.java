package com.eswproject.lightsouls.Domain;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.List;

@Entity
public class DescrittoreDungeon {

    public void setBossName(String bossName) {
        BossName = bossName;
    }

    @Id
    private String BossName;

	public List<DescrittoreIncontro> getListaIncontri() {
        return listaIncontri;
    }


    @OneToMany(fetch = FetchType.EAGER)
    private List<DescrittoreIncontro> listaIncontri;

}