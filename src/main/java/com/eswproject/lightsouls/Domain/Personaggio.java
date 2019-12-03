package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

	public List<Titanite> getTitaniti() {
		return titaniti;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> titaniti;

	public List<Equipment> getEquipaggiamenti() {
		return equipaggiamenti;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Equipment> equipaggiamenti;

	public void setStatisticaBase(StatisticaBase statisticaBase) {
		this.statisticaBase = statisticaBase;
	}

	public StatisticaBase getStatisticaBase() {
		return statisticaBase;
	}

}