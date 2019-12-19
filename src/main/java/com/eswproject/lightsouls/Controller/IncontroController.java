package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;

@RestController
@CrossOrigin("http://localhost:4200")
public class IncontroController extends Observable {

	private DescrittoreIncontro descrittoreIncontro;

	private LinkedList<StatisticheCombattimentoBase> listaTurni;

	boolean isComplete = false;

	@Autowired
	private PersonaggioController personaggioController;

	private GestoreIncontro gestoreIncontro= GestoreIncontro.getInstance();

	@GetMapping("/RiepilogoIncontro")
	public DescrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public boolean isComplete() {
		return this.isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro() {
		this.listaTurni= new LinkedList<>();
		this.listaTurni.add(new StatisticheCombattimentoPersonaggio(this.personaggioController.getDescrittorePersonaggio()));
		for(NemicoWrapper nemicoWrapper: this.descrittoreIncontro.getNemiciWrappers()){
			for(int i=0;i<nemicoWrapper.getNumberNemici();i++)
				this.listaTurni.add(new StatisticheCombattimentoBase(nemicoWrapper.getDescrittoreNemico()));
		}
		Collections.sort(listaTurni);
		return getTurno();
	}

	@GetMapping("/Turno")
	public String getTurno(){
		if(this.listaTurni.peekFirst().getClass().getSimpleName().equals("StatisticheCombattimentoPersonaggio")){
			return "/TurnoPersonaggio";
		}
		else
			return "/TurnoNemico";
	}

	@PostMapping("/Attacca/{posizioneNemico}")
	public void Attacca(@PathVariable("posizioneNemico")int posizioneNemico,@RequestBody AzioneWrapper azioneWrapper){
		StatisticheCombattimentoBase nemico=this.listaTurni.get(posizioneNemico);
		int danno=azioneWrapper.getAzione().getDiceRoll()-
				nemico.getDescrittorePersonaggioBase().getDifesa();
		if(danno>0){
			int HpLeft=nemico.getHP()-danno;
			System.out.println(HpLeft);
			if(HpLeft>0)
				nemico.setHP(HpLeft);
			else
				this.listaTurni.remove(nemico);
		}
		System.out.println(nemico.getHP());
	}

	@GetMapping("/ListaTurni")
	public LinkedList<StatisticheCombattimentoBase> getListaTurni(){
		return listaTurni;
	}

	/*public String Avvia() {
		setChanged();
		notifyObservers();
		return "/Incontro";
	}*/


}
