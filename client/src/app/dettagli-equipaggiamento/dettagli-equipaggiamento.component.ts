import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpService} from '../http.service';

@Component({
  selector: 'app-dettagli-equipaggiamento',
  templateUrl: './dettagli-equipaggiamento.component.html',
  styleUrls: ['./dettagli-equipaggiamento.component.css']
})
export class DettagliEquipaggiamentoComponent implements OnInit {

  id ;
  equipaggiamento:any;
  titaniti: any[];

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state;
    this.httpservice.DettagliEquipaggiamento(this.equipaggiamento.id).subscribe(titaniti => this.titaniti = titaniti);
  }
  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Usa(diceColor: any): void {
    this.httpservice.Potenzia(this.equipaggiamento.id, diceColor).subscribe(url => this.router.navigate([url]));
}




}
