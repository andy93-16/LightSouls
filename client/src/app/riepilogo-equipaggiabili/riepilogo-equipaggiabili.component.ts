import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-riepilogo-equipaggiabili',
  templateUrl: './riepilogo-equipaggiabili.component.html',
  styleUrls: ['./riepilogo-equipaggiabili.component.css']
})
export class RiepilogoEquipaggiabiliComponent implements OnInit {

  equipaggiamenti: any[];
  equipaggiamentoDaCambiare: any;

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamentoDaCambiare = this.router.getCurrentNavigation().extras.state;
    this.httpservice.RiepilogoEquipaggiabili( this.equipaggiamentoDaCambiare.value.id ).subscribe(equipaggiamenti =>
      this.equipaggiamenti = equipaggiamenti);
  }

  ngOnInit() {
  }

  TornaACambiaEquipaggiamento(): void {
    this.router.navigate(['/CambiaEquipaggiamento']);
  }

  Scambia(equipaggiamentoOutId: number, equipaggiamentoInId: number): void {
    this.httpservice.Scambia(equipaggiamentoOutId, equipaggiamentoInId).subscribe(
      url => this.router.navigate([url]));
}


}
