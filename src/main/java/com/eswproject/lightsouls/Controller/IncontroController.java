package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

@RestController
@CrossOrigin("http://localhost:4200")
public class IncontroController extends Observable implements Observer {

	private DescrittoreIncontro descrittoreIncontro;

	private LinkedList<StatisticheCombattimentoBase> listaTurni;

	public void setStatisticheCombattimentoPersonaggio(StatisticheCombattimentoPersonaggio statisticheCombattimentoPersonaggio) {
		this.statisticheCombattimentoPersonaggio = statisticheCombattimentoPersonaggio;
	}

	private StatisticheCombattimentoPersonaggio statisticheCombattimentoPersonaggio;

	@GetMapping("/ListaTurni")
	public LinkedList<StatisticheCombattimentoBase> getListaTurni(){
		return listaTurni;
	}

	@GetMapping("/RiepilogoIncontro")
	public DescrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro() {
		this.listaTurni= new LinkedList<>();
		this.listaTurni.add(statisticheCombattimentoPersonaggio);
		for(NemicoWrapper nemicoWrapper: this.descrittoreIncontro.getNemiciWrappers()){
			for(int i=0;i<nemicoWrapper.getNumberNemici();i++)
				this.listaTurni.add(new StatisticheCombattimentoNemico(nemicoWrapper.getDescrittoreNemico()));
		}
		Collections.sort(listaTurni);
		return getTurno();
	}

	@GetMapping("/Turno")
	public String getTurno(){
		if(this.listaTurni.peekFirst().equals(statisticheCombattimentoPersonaggio)){
			return "/TurnoPersonaggio";
		}
		else
			return "/TurnoNemico";
	}

	@GetMapping("/PassaTurno")
	public void PassaTurno(){
          StatisticheCombattimentoBase statisticheCombattimentoBase=this.listaTurni.pollFirst();
          this.listaTurni.offerLast(statisticheCombattimentoBase);
	}

	@PostMapping("/Attacca/{posizioneNemico}")
	public String Attacca(@PathVariable("posizioneNemico")int posizioneNemico,@RequestBody AttaccoMapper attaccoMapper){
		this.listaTurni.get(posizioneNemico).
				infliggiDanno(statisticheCombattimentoPersonaggio.
						calcolaDanno(attaccoMapper.getPosizioneArma(),attaccoMapper.getPosizioneAttacco()));
		return "/TurnoPersonaggio";
	}
	@GetMapping("/Difendi")
	public void Difendi(){
		statisticheCombattimentoPersonaggio.infliggiDanno(
				this.listaTurni.peekFirst().calcolaDanno(0,0));
	}

	/*public String Avvia() {
		setChanged();
		notifyObservers();
		return "/Incontro";
	}*/

	@GetMapping("/TornaAlFalo")
	public String TornaAlFalo(){
		statisticheCombattimentoPersonaggio.resetStatistiche();
		return "/TornaAlFalo";
	}

	@Override
	public void update(Observable statisticaCombattimento,Object stato){


	}


}
