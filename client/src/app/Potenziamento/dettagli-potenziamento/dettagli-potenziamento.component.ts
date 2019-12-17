import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpService} from '../../http.service';

@Component({
  selector: 'app-dettagli-equipaggiamento',
  templateUrl: './dettagli-potenziamento.component.html',
  styleUrls: ['./dettagli-potenziamento.component.css']
})
export class DettagliPotenziamentoComponent implements OnInit {

  equipaggiamento: any;
  titaniti: any[];

  constructor(private httpservice: HttpService, private router: Router) {
    this.equipaggiamento = this.router.getCurrentNavigation().extras.state;
    this.httpservice.TitanitiForEquipment(this.equipaggiamento).subscribe(titaniti => this.titaniti = titaniti);
  }
  ngOnInit() {
  }

  TornaRiepilogoEquipaggiamenti(): void {
    this.router.navigate(['/RiepilogoEquipaggiamenti']);
  }

  Usa(titanite: any): void {
    this.httpservice.Potenzia(this.equipaggiamento.id, titanite).subscribe(url => this.router.navigate([url]));
}




}