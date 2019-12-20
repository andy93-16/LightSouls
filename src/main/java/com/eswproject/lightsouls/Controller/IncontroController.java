package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.*;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.StatoTurno;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.TurnoNemico;
import com.eswproject.lightsouls.Domain.Combattimento.Stato.TurnoPersonaggio;
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

	public StatisticheCombattimentoPersonaggio getStatisticheCombattimentoPersonaggio() {
		return statisticheCombattimentoPersonaggio;
	}

	private StatisticheCombattimentoPersonaggio statisticheCombattimentoPersonaggio;

	private StatoTurno statoTurno;

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

		return statoTurno.getStatoTurno();
	}

	private void getTurnoListaTurni(){
		if(this.listaTurni.peekFirst().equals(this.statisticheCombattimentoPersonaggio)){
			statoTurno=new TurnoPersonaggio(this);
		}
		else
			statoTurno=new TurnoNemico(this);
	}

	@GetMapping("/PassaTurno")
	public String PassaTurno(){
          StatisticheCombattimentoBase statisticheCombattimentoBase=this.listaTurni.pollFirst();
          this.listaTurni.offerLast(statisticheCombattimentoBase);
          getTurnoListaTurni();
          return statoTurno.getStatoTurno();
	}

	@PostMapping("/Attacca/{posizioneNemico}")
	public String Attacca(@PathVariable("posizioneNemico")int posizioneNemico,@RequestBody AttaccoMapper attaccoMapper){
		return statoTurno.attacca(posizioneNemico,attaccoMapper);
	}

	@GetMapping("/Difendi")
	public void Difendi(){
		statisticheCombattimentoPersonaggio.infliggiDanno(
				this.listaTurni.peekFirst().calcolaDanno(0,0));
	}

	@GetMapping("/TornaAlFalo")
	public String TornaAlFalo(){
		statisticheCombattimentoPersonaggio.resetStatistiche();
		return "/Falo";
	}


	/*public String Avvia() {
		setChanged();
		notifyObservers();
		return "/Incontro";
	}*/


	@Override
	public void update(Observable statisticaCombattimento,Object stato){


	}


}
