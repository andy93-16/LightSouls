package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.*;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggioBase;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoNemico;
import com.eswproject.lightsouls.Domain.Personaggio.Personaggio;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class IncontroController extends Observable implements Observer {

	private DescrittoreIncontro descrittoreIncontro;

	private GestoreIncontro gestoreIncontro=new GestoreIncontro();

	private List<StatoNemico> statoNemici;

	private StatoPersonaggio statoPersonaggio;

	private Loot loot;

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public StatoPersonaggio getStatoPersonaggio() {
		return statoPersonaggio;
	}

	public void setStatoPersonaggio(StatoPersonaggio statoPersonaggio) {
		this.statoPersonaggio = statoPersonaggio;
		this.statoPersonaggio.addObserver(this);
	}

	@GetMapping("/ListaTurni")
	public LinkedList<StatoPersonaggioBase> ListaTurni() {
		return gestoreIncontro.getListaTurni();
	}

	@GetMapping("/RiepilogoIncontro")
	public DescrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro() {
		loot=null;
		setNemici();
		statoPersonaggio.resetStato();
		gestoreIncontro.setConcluso(false);
		return gestoreIncontro.Avvia(statoPersonaggio,statoNemici);
	}

	@GetMapping("/PassaTurno")
	public String PassaTurno() {
		return gestoreIncontro.PassaTurno();
	}

	@PostMapping("/Attacca/{posizioneNemico}")
	public String Attacca(@PathVariable("posizioneNemico") int posizioneNemico, @RequestBody AttaccoMapper attaccoMapper) {
		return gestoreIncontro.Attacca(posizioneNemico,attaccoMapper);
	}

	@GetMapping("/Difendi")
	public String Difendi() {
		return gestoreIncontro.Difendi(statoPersonaggio);
	}

	@GetMapping("/Schiva")
	public String Schiva() {
		return gestoreIncontro.Schiva(statoPersonaggio);
	}

	@GetMapping("/TornaAlFalo")
	public String TornaAlFalo() {

		return "/Falo";
	}

	@GetMapping("/Loot")
	public Loot GetLoot() {
		return loot;
	}

	@Override
	public void update(Observable statoPersonaggioBase, Object stato) {
		if (((StatoPersonaggioBase) statoPersonaggioBase).isDead()){
			if (statoPersonaggioBase.equals(statoPersonaggio)) {
				gestoreIncontro.setConcluso(true);
			}
			else
			{
				statoNemici.remove(statoPersonaggioBase);
				if (statoNemici.isEmpty()){
					gestoreIncontro.setConcluso(true);
					loot=gestoreIncontro.generaLoot(statoPersonaggio,descrittoreIncontro.getLootablesEquip(),
							descrittoreIncontro.getLootableTitanites(),descrittoreIncontro.getLootableAnime());
					Personaggio personaggio=(Personaggio)statoPersonaggio.getPersonaggioBase();
					personaggio.aggiungiLoot(loot);
					setChanged();
					notifyObservers();
				}
			}
		}
		else
			gestoreIncontro.ConcludiTurno();
	}

	private void setNemici() {
		statoNemici=new ArrayList<>();
		for (NemicoWrapper nemicoWrapper : descrittoreIncontro.getNemiciWrappers())
			for (int i = 0; i < nemicoWrapper.getNumberNemici(); i++) {
				StatoNemico statoNemico = nemicoWrapper.getStatoNemico().clone();
				statoNemico.resetStato();
				statoNemico.addObserver(this);
				statoNemici.add(statoNemico);
			}
	}


}
