import {Component, OnInit} from '@angular/core';
import {HttpService} from '../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'equipaggia-personaggio',
  templateUrl: './equipaggia-personaggio.component.html',
  styleUrls: ['./equipaggia-personaggio.component.css']
})
export class EquipaggiaPersonaggioComponent implements OnInit {

  equipaggiati: any[];
  equipaggiabili: any[];
  nonEquipaggiabili: any[];

  constructor(private httpservice: HttpService, private router: Router) {
  }

  ngOnInit() {
    this.httpservice.RiepilogoEquipaggiati().subscribe(
      equipaggiamenti => this.equipaggiati = equipaggiamenti);
    this.httpservice.RiepilogoEquipaggiabili().subscribe(
      equipaggiamenti => this.equipaggiabili = equipaggiamenti);
    this.httpservice.RiepilogoNonEquipaggiabili().subscribe(
      equipaggiamenti => this.nonEquipaggiabili = equipaggiamenti);
  }

  Equipaggia(equipaggiamento: any): void {
    this.router.navigate(['/ChooseBodyPart'],
      {state: { equipaggiamentoSelezionato: equipaggiamento}});
  }

  Disequipaggia(equipaggiamentoId: number): void {
    this.httpservice.Disequipaggia(equipaggiamentoId).subscribe(
      url => this.router.navigate([url])
    );
    this.ngOnInit();
  }

  TornaGestisciPersonaggio(): void {
    this.router.navigate([ '/GestisciPersonaggio']);
  }
}
