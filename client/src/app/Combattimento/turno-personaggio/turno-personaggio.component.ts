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
  personaggio: any = [];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.ListaTurni().subscribe(listaTurni => {
      this.listaTurni = listaTurni;
      this.GetPersonaggio();
      this.ListaNemici();
    });

  }

  ListaNemici(): void{
    this.listaTurni.forEach(statisticheCombattimento => {
      if (statisticheCombattimento.descrittorePersonaggioBase.type === 'Nemico') {
        this.listaNemici.push(statisticheCombattimento);
      }
    });
  }

  GetPersonaggio(): void{
    this.personaggio = this.listaTurni.find( statisticheCombattimento => {
      return statisticheCombattimento.descrittorePersonaggioBase.type === 'Personaggio'; });
  }

  PassaTurno(): void{
  /*  this.httpservice.PassaTurno();*/
  }

  CambiaEquipaggiamento(): void{
    this.router.navigate(['/CambiaEquipaggiamento']);
  }
  Attacca(nemico: any) {
    this.router.navigate(['/SelezioneAttacco'], {state :
        { personaggio : this.personaggio,
          nemicoSelezionato : this.listaTurni.indexOf(nemico)}});
  }

  ngOnInit() {
  }

}
