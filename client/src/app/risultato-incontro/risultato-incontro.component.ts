import { Component, OnInit } from '@angular/core';
import {RouterService} from '../router.service';

@Component({
  selector: 'app-risultato-incontro',
  templateUrl: './risultato-incontro.component.html',
  styleUrls: ['./risultato-incontro.component.css']
})
export class RisultatoIncontroComponent implements OnInit {

  constructor(private routerService: RouterService) { }

  ngOnInit() {
  }

  TornaAlFalo(): void  {
    this.routerService.RouteTo('/Falo') ;
  }

}
