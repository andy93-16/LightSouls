package com.eswproject.lightsouls.Controller;

import com.eswproject.lightsouls.Domain.Artifacts.BodyPersonaggio;
import com.eswproject.lightsouls.Domain.Artifacts.Equipment;
import com.eswproject.lightsouls.Domain.Artifacts.StrategiaCambioEquipments;
import com.eswproject.lightsouls.Domain.Artifacts.Titanite;
import com.eswproject.lightsouls.Domain.Dice.DiceColor;
import com.eswproject.lightsouls.Domain.Personaggio;
import com.eswproject.lightsouls.Service.EquipmentService;
import com.eswproject.lightsouls.Service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("http://localhost:4200")
public class PersonaggioController {

    @Autowired
    PersonaggioService pS;

    @Autowired
    EquipmentService eS;

    Personaggio personaggio;

    StrategiaCambioEquipments sce;

    public Personaggio getPersonaggio() {
        return personaggio;
    }
    public EquipmentService geteS() {
        return eS;
    }

    @GetMapping("/SetPersonaggio")
    public void SetPersonaggio() {
        personaggio=this.pS.findById(1);
    }

    @GetMapping("/RiepilogoEquipaggiamenti")
    public List<Equipment> RiepilogoEquipaggiamenti() {
        List<Equipment> equipaggiamenti= new ArrayList<>();
        equipaggiamenti.addAll(personaggio.getZainoEquip());
        equipaggiamenti.addAll(personaggio.getCurrentEquipped().values());
		return equipaggiamenti;
    }

	@GetMapping("/PotenziaEquipaggiamento/{idE}&{idT}")
	public String PotenziaEquipaggiamento(@PathVariable("idE")int idE,@PathVariable("idT")DiceColor diceColor)
    {   Equipment eq = null;
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == idE)
            {
                eq = equipment;
                break;
            }
        }
        if(eq.getUpgradesLeft()>0) //No more upgradable
        {
            eq.setUpgradesLeft(eq.getUpgradesLeft() - 1);
            eq.addDice(diceColor);
            for (Titanite titanite : this.personaggio.getTitaniti()) {
                if (titanite.getEquipmentType().EquipmentClass().isInstance(eq) & titanite.getDiceColor() == diceColor)
                    titanite.setAvailable(titanite.getAvailable() - 1);
            }
        }
       return "/RiepilogoEquipaggiamenti";
    }

    @GetMapping("/DettagliEquipaggiamento/{id}")
    public List<Titanite> DettagliEquipaggiamento(@PathVariable(name="id")int id){
        Equipment eq=null;
        for (Equipment equipment : this.personaggio.getZainoEquip())
        {
            if (equipment.getId() == id) {
                eq = equipment;
                break;
            }
        }
        List<Titanite> titanites= new ArrayList<>();
        for (Titanite titanite: this.personaggio.getTitaniti())
        {
            if (titanite.getEquipmentType().EquipmentClass().isInstance(eq))
                    titanites.add(titanite);
        }
        return titanites;
    }

    @GetMapping("/RiepilogoEquipaggiati")
    public Map<BodyPersonaggio,Equipment> RiepilogoEquipaggiati(){
        return this.personaggio.getCurrentEquipped();
    }

    @GetMapping("/RiepilogoEquipaggiabili/{id}")
    public List<Equipment> RiepilogoEquipaggiabili(@PathVariable(name="id")int id){
        Equipment eq=null;
        for(Equipment equipment: this.personaggio.getCurrentEquipped().values())
        {
            if(equipment.getId()==id) {
                eq = equipment;
                break;
            }
        }
        List<Equipment> equipaggiabili=new ArrayList<>();
        for(Equipment equipment: this.personaggio.getZainoEquip())
        {
            if(equipment.getClass()==eq.getClass())
                equipaggiabili.add(equipment);
        }
        return equipaggiabili;
    }
    @GetMapping("/Scambia/{idOut}&{idIn}")
    public String Scambia(@PathVariable("idOut")int idOut,@PathVariable("idIn")int idIn){
        int eqInPosition=0;
        BodyPersonaggio eqOutPartName=null;
        for(int i=0;i<this.personaggio.getZainoEquip().size();i++)
        {
            if(this.personaggio.getZainoEquip().get(i).getId()==idIn)
                eqInPosition=i;
        }
        for(BodyPersonaggio bp: this.personaggio.getCurrentEquipped().keySet())
        {
            if(this.personaggio.getCurrentEquipped().get(bp).getId()==idOut)
                eqOutPartName=bp;
        }
        try {
            String eqclassname = eqOutPartName.getClass().getPackage().getName()+".Cambio"+eqOutPartName.getEqType();
            this.sce=(StrategiaCambioEquipments) Class.forName(eqclassname).newInstance();
            this.sce.setpC(this);
        }
        catch(ClassNotFoundException cnf){System.out.println(cnf);}
        catch(InstantiationException ie){System.out.println(ie);}
        catch(IllegalAccessException ia){System.out.println(ia);}
        this.sce.CambioEquipments(eqOutPartName,eqInPosition);
        return "/CambiaEquipaggiamento";
    }
    @GetMapping("/RimuoviEquipment/{bp}")
    public void RimuoviEquipment(@PathVariable("bp")BodyPersonaggio bp){
        String eqclassname = bp.getClass().getPackage().getName()+".Cambio"+bp.getEqType();
        try
        {
        this.sce=(StrategiaCambioEquipments) Class.forName(eqclassname).newInstance();
        this.sce.setpC(this);
        }
        catch(ClassNotFoundException cnf){System.out.println(cnf);}
        catch(InstantiationException ie){System.out.println(ie);}
        catch(IllegalAccessException ia){System.out.println(ia);}
        this.sce.RimuoviEquipment(bp);
    }

}
