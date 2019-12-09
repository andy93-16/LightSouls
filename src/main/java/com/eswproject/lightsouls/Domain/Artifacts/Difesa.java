package com.eswproject.lightsouls.Domain.Artifacts;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Difesa")
public class Difesa extends Azione{

}