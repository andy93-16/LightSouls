package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.*;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggio;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoPersonaggioBase;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoNemico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class IncontroController extends Observable implements Observer {

	private DescrittoreIncontro descrittoreIncontro;

	private GestoreIncontro gestoreIncontro=new GestoreIncontro();

	private List<StatoNemico> statoNemici=new ArrayList<>();

	private StatoPersonaggio statoPersonaggio;

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
		setNemici();
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

	@GetMapping("/TornaAlFalo")
	public String TornaAlFalo() {
		return "/Falo";
	}

	@Override
	public void update(Observable statoPersonaggioBase, Object stato) {
		if (((StatoPersonaggioBase) statoPersonaggioBase).isDead()) {
			if (statoPersonaggioBase.equals(statoPersonaggio))
				gestoreIncontro.setConcluso(true);
			else
			{
				statoNemici.remove(statoPersonaggioBase);
				if (statoNemici.isEmpty()){
					gestoreIncontro.setConcluso(true);
					setChanged();
					notifyObservers();
				}
			}
		}
		else
			PassaTurno();
	}

	private void setNemici() {
		for (NemicoWrapper nemicoWrapper : descrittoreIncontro.getNemiciWrappers())
			for (int i = 0; i < nemicoWrapper.getNumberNemici(); i++) {
				StatoNemico statoNemico = nemicoWrapper.getStatoNemico().clone();
				statoNemico.resetStato();
				statoNemico.addObserver(this);
				statoNemici.add(statoNemico);
			}
	}


}
