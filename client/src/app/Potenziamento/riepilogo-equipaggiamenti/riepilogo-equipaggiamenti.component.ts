import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-riepilogo-equipaggiamenti',
  templateUrl: './riepilogo-equipaggiamenti.component.html',
  styleUrls: ['./riepilogo-equipaggiamenti.component.css']
})
export class RiepilogoEquipaggiamentiComponent implements OnInit {

  personaggio: any;
  equipaggiamenti: any[] = [];

  constructor(private httpservice: HttpService, private router: Router) {
    this.httpservice.RiepilogoPersonaggio().subscribe(personaggio => {
      this.personaggio = personaggio;
      this.equipaggiamenti = this.equipaggiamenti.concat(this.personaggio.zainoEquip)
        .concat(this.personaggio.equipaggiati);
      });
  }

  ngOnInit() {
  }

  TitanitiForEquipment(equipaggiamento: any): any[] {
    const titaniti: any[] = [];
    this.personaggio.titaniti.forEach( titanite => {
      if (titanite.equipmentType === equipaggiamento.type) {
            titaniti.push(titanite);
      }
    });
    return titaniti;
  }

  DettagliPotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliPotenziamento'], { state: { equipaggiamentoSelezionato : equipaggiamento,
      titanitiForEquipment : this.TitanitiForEquipment(equipaggiamento)}});
  }

  DettagliDepotenziamento(equipaggiamento: any): void {
    this.router.navigate(['/DettagliDepotenziamento'], { state: equipaggiamento});
  }

  TornaGestisciPersonaggio(): void {
    this.router.navigate(['/GestisciPersonaggio']);
  }
}
