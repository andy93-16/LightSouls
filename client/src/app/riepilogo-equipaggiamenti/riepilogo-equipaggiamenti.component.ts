import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {RouterService} from '../router.service';

@Component({
  selector: 'app-riepilogo-equipaggiamenti',
  templateUrl: './riepilogo-equipaggiamenti.component.html',
  styleUrls: ['./riepilogo-equipaggiamenti.component.css']
})
export class RiepilogoEquipaggiamentiComponent implements OnInit {

  equipaggiamenti: any[];

  constructor(private httpservice: HttpService, private routerService: RouterService) { }

  ngOnInit() {
    this.httpservice.RiepilogoEquipaggiamenti().subscribe(equipaggiamenti => {
      this.equipaggiamenti = equipaggiamenti;
    });
  }

  DettagliEquipaggiamento(equipaggiamento: any): void {
    this(['/RiepilogoEquipaggiamenti'], { equipaggaimento: { equipaggiamento }}]);
  }

}
