package com.eswproject.lightsouls.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class DescrittoreDungeon {

    @Id
    private String BossName;

	public List<DescrittoreIncontro> getListaIncontri() {
        return listaIncontri;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<DescrittoreIncontro> listaIncontri;

}