package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Combattimento.GestoreIncontro;
import com.eswproject.lightsouls.Domain.Combattimento.DescrittoreIncontro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Observable;

@RestController
@CrossOrigin("http://localhost:4200")
public class IncontroController extends Observable {

	private DescrittoreIncontro descrittoreIncontro;

	boolean isComplete = false;

	@Autowired
	private PersonaggioController personaggio;

    private GestoreIncontro gestoreIncontro;

    public GestoreIncontro getGestoreIncontro() {
        return gestoreIncontro;
    }

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
		this.gestoreIncontro.Init(this.personaggio.GetPersonaggio(),this.descrittoreIncontro.getNemicoWrappers());
		return Avvia();
	}

	public String Avvia() {
		setChanged();
		notifyObservers();
		return "/RisultatoIncontro";
	}
}
