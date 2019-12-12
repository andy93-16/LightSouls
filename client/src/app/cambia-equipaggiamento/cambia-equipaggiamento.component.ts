import {Component, OnInit} from '@angular/core';
import {HttpService} from '../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cambia-equipaggiamento',
  templateUrl: './cambia-equipaggiamento.component.html',
  styleUrls: ['./cambia-equipaggiamento.component.css']
})
export class CambiaEquipaggiamentoComponent implements OnInit {

  currentEquipped: any[];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.RiepilogoEquipaggiati().subscribe(equipaggiati => this.currentEquipped = equipaggiati);
  }

  ngOnInit() {
  }

  Cambia(equipaggiamentoDaCambiare: any): void {
    this.router.navigate(['/RiepilogoEquipaggiabili'],
      {state: equipaggiamentoDaCambiare, skipLocationChange: true});
  }

  TornaGestisciPersonaggio(): void {
    this.router.navigate([ '/GestisciPersonaggio']);
  }

  Rimuovi(equipaggiamento: any): void {
    this.httpservice.Rimuovi(equipaggiamento.key).subscribe( url => this.router.navigate(url));
  }

}
