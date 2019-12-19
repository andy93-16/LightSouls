package com.eswproject.lightsouls.Domain.Partita;

import com.eswproject.lightsouls.Domain.Combattimento.DescrittoreIncontro;

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