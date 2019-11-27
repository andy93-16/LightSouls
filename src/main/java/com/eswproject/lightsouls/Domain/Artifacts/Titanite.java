package com.eswproject.lightsouls.Domain.Artifacts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Titanite")
public class Titanite extends Artefatto {
}