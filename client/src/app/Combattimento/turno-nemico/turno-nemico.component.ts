import { Component, OnInit } from '@angular/core';
import {HttpService} from "../../http.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-turno-nemico',
  templateUrl: './turno-nemico.component.html',
  styleUrls: ['./turno-nemico.component.css']
})
export class TurnoNemicoComponent implements OnInit {

  listaTurni: any[] = [];
  listaNemici: any[] = [];
  statoPersonaggio: any = [];

  constructor(private httpservice: HttpService, private router: Router) {
  }

  ngOnInit() {
    this.httpservice.ListaTurni().subscribe(listaTurni => {
      this.listaTurni = listaTurni;
      this.GetPersonaggio();
      this.ListaNemici();
    });
  }

  ClearCache():void {
    this.listaTurni=[];
    this.listaNemici=[];
    this.statoPersonaggio=[];
  }

  ListaNemici(): void{
    this.listaTurni.forEach(statoPersonaggio => {
      if (statoPersonaggio.personaggioBase.type === 'Nemico') {
        this.listaNemici.push(statoPersonaggio);
      }
    });
  }

  GetPersonaggio(): void{
    this.statoPersonaggio = this.listaTurni.find( statoPersonaggio => {
      return statoPersonaggio.personaggioBase.type === 'Personaggio'; });
  }

  Difendi(): void{
    this.ClearCache();
    this.httpservice.Difendi().subscribe(url => {
         this.router.navigate([url])});
    this.ngOnInit();
  }

  Schiva(): void{
      this.ClearCache();
      this.httpservice.Schiva().subscribe(url => {
        this.router.navigate([url])});
      this.ngOnInit();
  }

}
