import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpService} from '../../http.service';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-dettagli-equipaggiamento',
  templateUrl: './dettagli-potenziamento.component.html',
  styleUrls: ['./dettagli-potenziamento.component.css']
})
export class DettagliPotenziamentoComponent implements OnInit {

  equipaggiamento: any;
  titaniti: any[];
  equipaggiamentoPos: number;
  statoPersonaggio: any;

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state.equipaggiamentoSelezionato;
    this.statoPersonaggio = this.router.getCurrentNavigation().extras.state.statoPersonaggio;
    this.titaniti = this.TitanitiForEquipment(this.equipaggiamento);
  }

  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  TitanitiForEquipment(equipaggiamento: any): any[] {
    const titaniti: any[] = [];
    this.statoPersonaggio.personaggioBase.titaniti.forEach( titanite => {
      if (titanite.equipmentType === equipaggiamento.type) {
        titaniti.push(titanite);
      }
    });
    return titaniti;
  }

  Usa(titanite: any): void {
    this.equipaggiamentoPos= this.statoPersonaggio.personaggioBase.zainoEquip.indexOf(this.equipaggiamento),
    this.httpservice.Potenzia(this.equipaggiamentoPos, titanite).subscribe(url => this.router.navigate([url]));
    console.log(this.equipaggiamentoPos);
  }

}
