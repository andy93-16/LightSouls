import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {RouterService} from '../router.service';

@Component({
  selector: 'app-riepilogo-equipaggiabili',
  templateUrl: './riepilogo-equipaggiabili.component.html',
  styleUrls: ['./riepilogo-equipaggiabili.component.css']
})
export class RiepilogoEquipaggiabiliComponent implements OnInit {

  equipaggiabili: any[];

  constructor(private httpservice: HttpService, private routerService: RouterService) { }

  ngOnInit() {
    this.httpservice.RiepilogoEquipaggiabili().subscribe(equipaggiabili => {
      this.equipaggiabili = equipaggiabili;
    });
  }

}
