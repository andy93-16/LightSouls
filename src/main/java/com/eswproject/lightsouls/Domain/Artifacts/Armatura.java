package com.eswproject.lightsouls.Domain.Artifacts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Armatura")
public class Armatura extends Equipment
{
}
