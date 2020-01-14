import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpService} from "../../http.service";
import {AttaccoOfArma} from "../selezione-attacco/attacco-of-arma";

@Component({
  selector: 'app-risultato-incontro',
  templateUrl: './risultato-incontro.component.html',
  styleUrls: ['./risultato-incontro.component.css']
})
export class RisultatoIncontroComponent implements OnInit {

  statopersonaggio : any;
  statonemici : any[]=[];
  loot : any;
  listaTurni : any[];

  constructor(private router: Router,private httpservice: HttpService) {
    this.httpservice.ListaTurni().subscribe(listaTurni => {
      this.listaTurni = listaTurni;
      this.FiltraPersonaggio();
      this.FiltraNemici();
    });

    this.httpservice.GetLoot().subscribe(loot=>{
      this.loot= loot;
    });
  }

  ngOnInit() {
  }

  TornaAlFalo(): void  {
    this.router.navigate(['/Falo']) ;
  }

  FiltraPersonaggio():void{
    this.listaTurni.forEach(
    statoPersonaggioBase => {
    if ( statoPersonaggioBase.personaggioBase.type === 'Personaggio') {
      this.statopersonaggio=statoPersonaggioBase;
    }
    }
  );
  }

  FiltraNemici():void{
    this.listaTurni.forEach(
      statoPersonaggioBase => {
        if ( statoPersonaggioBase.personaggioBase.type === 'Nemico') {
          this.statonemici.push(statoPersonaggioBase);
        }
      }
    );
  }
}
