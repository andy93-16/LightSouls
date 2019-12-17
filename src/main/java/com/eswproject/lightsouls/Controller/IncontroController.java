package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.DescrittoreIncontro;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Observable;

@RestController
@CrossOrigin("http://localhost:4200")
public class IncontroController extends Observable {

	private DescrittoreIncontro descrittoreIncontro;

	boolean complete = false;

	public String Avvia() {
		setChanged();
		notifyObservers();
		return "/RisultatoIncontro";
	}


	public DescrittoreIncontro getDescrittoreIncontro() {
		return this.descrittoreIncontro;
	}

	public void setDescrittoreIncontro(DescrittoreIncontro descrittoreIncontro) {
		this.descrittoreIncontro = descrittoreIncontro;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean isComplete) {
		this.complete = isComplete;
	}

	@GetMapping("/AvviaIncontro")
	public String AvviaIncontro() {
		return Avvia();
	}
}
