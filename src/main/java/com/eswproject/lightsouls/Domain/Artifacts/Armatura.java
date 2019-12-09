package com.eswproject.lightsouls.Domain.Artifacts;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Armatura")
public class Armatura extends Equipment
{
}
