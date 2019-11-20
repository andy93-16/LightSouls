import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {RouterService} from '../router.service';

@Component({
  selector: 'app-falo',
  templateUrl: './falo.component.html',
  styleUrls: ['./falo.component.css']
})
export class FaloComponent implements OnInit {

  constructor(private httpservice: HttpService, private routerService: RouterService) {}

  ngOnInit() {
    this.httpservice.ProcediAdIncontro().subscribe( incontro => {
      if (incontro === null) {
        this.routerService.RouteTo('/RisultatoPartita');
     }
    });
  }

  ProcediAdIncontro(): void {
    this.routerService.RouteTo('/Incontro');
  }

  Termina(): void {
    this.httpservice.Termina();
  }

}
