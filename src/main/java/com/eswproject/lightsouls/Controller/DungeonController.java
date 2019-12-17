package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.DescrittoreIncontro;


import org.springframework.stereotype.Controller;



import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

@Controller
public class DungeonController implements Observer
{

	private boolean complete=false;

	private Iterator<DescrittoreIncontro> iterIncontri;

	private IncontroController incontroController ;


	@Override
	public void update(Observable incontro, Object stato)
	{
		if(iterIncontri.hasNext())
			nextIncontro();
		else
			setComplete(true);

	}

	public void nextIncontro()
	{
		this.incontroController.setDescrittoreIncontro(iterIncontri.next().clone());
		this.incontroController.addObserver(this);
	}

	public void resettaIncontri()
	{}

	public void setIterIncontri(java.util.Iterator<DescrittoreIncontro> iterIncontri)
	{
		this.iterIncontri = iterIncontri;
	}


	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}