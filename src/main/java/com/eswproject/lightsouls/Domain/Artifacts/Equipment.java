package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.Artifacts.*;
import com.eswproject.lightsouls.Domain.StatisticaBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipment extends Artefatto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int upgradesLeft;

	@OneToOne
	private StatisticaBase minRequirements;

	@OneToMany
	private List<Attacco> attacchi;

	@OneToMany
	private List<Difesa> difese;

}