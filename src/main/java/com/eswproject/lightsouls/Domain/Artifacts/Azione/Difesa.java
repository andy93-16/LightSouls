package com.eswproject.lightsouls.Domain.Artifacts.Azione;

import com.eswproject.lightsouls.Domain.Artifacts.Azione.Azione;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Difesa")
public class Difesa extends Azione {

}