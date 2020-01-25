import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpService} from '../../http.service';

@Component({
  selector: 'app-dettagli-equipaggiamento',
  templateUrl: './dettagli-potenziamento.component.html',
  styleUrls: ['./dettagli-potenziamento.component.css']
})
export class DettagliPotenziamentoComponent implements OnInit {

  statoPersonaggio : any;
  equipaggiamento : any;
  titaniti: any[] = [];

  constructor(private httpservice: HttpService, private router: Router) {

    this.equipaggiamento = this.router.getCurrentNavigation().extras.state.equipaggiamentoSelezionato;
    this.httpservice.RiepilogoPersonaggio().subscribe(statoPersonaggio => {
      this.statoPersonaggio = statoPersonaggio;
      this.TitanitiForEquipment(this.equipaggiamento);
    });
  }

  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Usa(titanite: any): void {
    this.httpservice.Potenzia(this.equipaggiamento.name
      , titanite).subscribe(url => this.router.navigate([url]));
  }

  TitanitiForEquipment(equipaggiamento: any): void {
    this.statoPersonaggio.personaggioBase.titaniti.forEach( titanite => {
      if (titanite.equipmentType === equipaggiamento.type) {
        this.titaniti.push(titanite);
      }
    });
  }
}
