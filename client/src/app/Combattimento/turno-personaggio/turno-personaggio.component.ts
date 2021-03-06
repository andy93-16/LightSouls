import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-turno-personaggio',
  templateUrl: './turno-personaggio.component.html',
  styleUrls: ['./turno-personaggio.component.css']
})
export class TurnoPersonaggioComponent implements OnInit {

  listaTurni: any[] = [];
  listaNemici: any[] = [];
  statoPersonaggio: any = [];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.ListaTurni().subscribe(listaTurni => {
      this.listaTurni = listaTurni;
      this.GetPersonaggio();
      this.ListaNemici();
    });

  }

  ListaNemici(): void{
    this.listaTurni.forEach( statoPersonaggio => {
      if (statoPersonaggio.personaggioBase.type === 'Nemico') {
        this.listaNemici.push(statoPersonaggio);
      }
    });
  }

  GetPersonaggio(): void{
    this.statoPersonaggio = this.listaTurni.find( statoPersonaggio => {
      return statoPersonaggio.personaggioBase.type === 'Personaggio'; });
  }

  PassaTurno(): void{
    this.httpservice.PassaTurno().subscribe(url => {
      this.router.navigate([url])});
  }


  Attacca(nemico: any) {
    this.router.navigate(['/SelezioneAttacco'], {state :
        { statoPersonaggio : this.statoPersonaggio,
          nemicoSelezionato : this.listaTurni.indexOf(nemico)}});
  }

  CambiaEquipaggiamento() {
    this.router.navigate(['/EquipaggiaPersonaggio'], { state :
        { prevUrl : this.router.url }}) ;
  }

  ngOnInit() {
  }

}
