package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.Arma;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Nemico")
public class Nemico extends PersonaggioBase {


}
