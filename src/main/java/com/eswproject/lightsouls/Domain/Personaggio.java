package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Artifacts.Artefatto;
import java.util.*;
import javax.persistence.*;


@Entity
public class Personaggio {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private StatisticaBase statisticaBase;

	@Transient
	private int anime=0;

	public List<Artefatto> getArtefatti() {
		return artefatti;
	}

	@OneToMany(fetch = FetchType.EAGER)
	private List<Artefatto> artefatti;

	public void setStatisticaBase(StatisticaBase statisticaBase) {
		this.statisticaBase = statisticaBase;
	}

	public StatisticaBase getStatisticaBase() {
		return statisticaBase;
	}

}