package com.eswproject.lightsouls.Domain.Personaggio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DescrittoreNemico")
public class DescrittoreNemico extends DescrittorePersonaggioBase
{

}
