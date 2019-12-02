package com.eswproject.lightsouls.Domain.Artifacts;

import com.eswproject.lightsouls.Domain.StatisticaBase;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Equipment")
public class Equipment extends Artefatto {

	private int upgradesLeft;

	public StatisticaBase getMinRequirements() {
		return minRequirements;
	}

	@OneToOne
	private StatisticaBase minRequirements;

	public List<Attacco> getAttacchi() {
		return attacchi;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Attacco> attacchi;

	public List<Difesa> getDifese() {
		return difese;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Difesa> difese;

	public int getUpgradesLeft() {
		return upgradesLeft;
	}


}