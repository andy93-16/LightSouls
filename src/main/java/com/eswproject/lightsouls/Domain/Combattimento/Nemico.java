package com.eswproject.lightsouls.Domain.Combattimento;

import com.eswproject.lightsouls.Domain.Artifacts.Azione;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Nemico extends PersonaggioBase
{

    @OneToMany(fetch = FetchType.EAGER)
    private List<Azione> azioni;

    public List<Azione> getAzioni()
    {
        return azioni;
    }


}
