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

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state.equipaggiamentoSelezionato;
    this.titaniti = this.router.getCurrentNavigation().extras.state.titanitiForEquipment;
    this.equipaggiamentoPos = this.router.getCurrentNavigation().extras.state.equipaggiamentoPos;
  }
  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Usa(titanite: any): void {
    this.httpservice.Potenzia(this.equipaggiamentoPos, titanite).subscribe(url => this.router.navigate([url]));
  }

}
