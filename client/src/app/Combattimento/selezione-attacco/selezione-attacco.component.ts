import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';
import {AttaccoOfArma} from './attacco-of-arma';



@Component({
  selector: 'app-selezione-attacco',
  templateUrl: './selezione-attacco.component.html',
  styleUrls: ['./selezione-attacco.component.css']
})

export class SelezioneAttaccoComponent implements OnInit {

  personaggio: any = [];
  posizioneNemico: any = [];
  listaAttaccoOfArma: any[] = [] ;

  constructor(private router: Router, private httpservice: HttpService) {
    this.personaggio = this.router.getCurrentNavigation().extras.state.personaggio;
    this.posizioneNemico = this.router.getCurrentNavigation().extras.state.nemicoSelezionato;
    this.ListaAttacchi();
    console.log(this.personaggio.descrittorePersonaggioBase.equipaggiati);
  }

  ListaAttacchi(): void {
    this.personaggio.descrittorePersonaggioBase.equipaggiati.forEach(
      equipaggiamento => { if ( equipaggiamento.type === 'Arma') {
           equipaggiamento.attacchi.forEach(azione => {
               const attaccoOfArma: AttaccoOfArma = {
               arma : equipaggiamento,
               attacco : azione};
               this.listaAttaccoOfArma.push(attaccoOfArma);
           });
        }
     }
    );
  }

  Usa(attacco: any): void {
    this.httpservice.Attacca(attacco, this.posizioneNemico).subscribe(url =>
     this.router.navigate([url]));

  }

  ngOnInit() {
  }

}
