package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Combattimento.NemiciWrapper;
import com.eswproject.lightsouls.Domain.Combattimento.Nemico;

import javax.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class DescrittoreIncontro
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    /*@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="enemy_combination",joinColumns ={@JoinColumn(name="descrittore_incontro_id",referencedColumnName = "id")})
    private Map<Nemico,Integer> nemici;

    public Map<Nemico,Integer> getNemici() {
        return nemici;
    }*/

    public List<NemiciWrapper> getNemiciWrappers() {
        return nemiciWrappers;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<NemiciWrapper> nemiciWrappers;

}