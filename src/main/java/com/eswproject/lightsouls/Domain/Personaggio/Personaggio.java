package com.eswproject.lightsouls.Domain.Personaggio;

import com.eswproject.lightsouls.Domain.Artifacts.*;
import com.eswproject.lightsouls.Domain.Combattimento.PersonaggioBase;
import com.eswproject.lightsouls.Domain.Combattimento.StatisticheCombattimentoPersonaggio;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.*;
import javax.persistence.*;

@Entity
public class Personaggio extends StatisticheCombattimentoPersonaggio
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	private StatisticheBase statisticheBase;

	private int anime;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Titanite> titaniti;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Equipment> zainoEquip;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BodyPart> bodyParts;






    public List<BodyPart> getBodyParts() {
        return this.bodyParts;
    }

    public int getId() {
        return id;
    }

	public List<Equipment> getZainoEquip() {
		return this.zainoEquip;
	}

	public List<Titanite> getTitaniti() {
		return this.titaniti;
	}

	public void setStatisticaBase(StatisticheBase statisticaBase) {
		this.statisticheBase = statisticaBase;
	}

	public StatisticheBase getStatisticaBase() {
		return this.statisticheBase;
	}

	public int getAnime() {
		return anime;
	}

	public void setAnime(int anime) {
		this.anime = anime;
	}

}