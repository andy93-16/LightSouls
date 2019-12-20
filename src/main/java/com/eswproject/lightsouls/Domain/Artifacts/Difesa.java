package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Dice.DiceColor;

import javax.persistence.*;
import java.util.Map;

@Entity
@DiscriminatorValue(value = "Difesa")
public class Difesa extends Azione
{

}