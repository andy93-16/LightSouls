package com.eswproject.lightsouls.Domain.Artifacts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Arma")
public class Arma extends DescrittoreEquipment
{
    public List<Attacco> getAttacchi() {
        return attacchi;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Attacco> attacchi;
}

