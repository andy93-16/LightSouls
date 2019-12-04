package com.eswproject.lightsouls.Domain;

import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import javax.persistence.*;


@Entity
public class Personaggio
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private StatisticaBase statisticaBase;

	@Transient
	private int anime = 0;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> titaniti;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Equipment> zainoEquip;


	@OneToOne
	private Equipment armaManoSinistra;

	@OneToOne
	private Equipment armaManoDestra;

	@OneToOne
	private Equipment armatura;


	public List<Equipment> getZainoEquip()
	{
		return this.zainoEquip;
	}

	public List<Titanite> getTitaniti()
	{
		return this.titaniti;
	}

	public void setStatisticaBase(StatisticaBase statisticaBase)
	{
		this.statisticaBase = statisticaBase;
	}

	public StatisticaBase getStatisticaBase()
	{
		return this.statisticaBase;
	}

	public int getAnime()
	{
		return anime;
	}

	public void setAnime(int anime)
	{
		this.anime = anime;
	}

	public Equipment getArmaManoSinistra()
	{
		return armaManoSinistra;
	}

	public void setArmaManoSinistra(Equipment armaManoSinistra)
	{
		this.armaManoSinistra = armaManoSinistra;
	}

	public Equipment getArmaManoDestra()
	{
		return armaManoDestra;
	}

	public void setArmaManoDestra(Equipment armaManoDestra)
	{
		this.armaManoDestra = armaManoDestra;
	}

	public Equipment getArmatura()
	{
		return armatura;
	}

	public void setArmatura(Equipment armatura)
	{
		this.armatura = armatura;
	}
}