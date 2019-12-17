import { Component, OnInit } from '@angular/core';
import {HttpService} from '../../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-incontro',
  templateUrl: './riepilogo-incontro.component.html',
  styleUrls: ['./riepilogo-incontro.css']
})
export class RiepilogoIncontroComponent implements OnInit {

  incontroCorrente: any;

  constructor(private httpservice: HttpService, private router: Router) {
    this.incontroCorrente = this.router.getCurrentNavigation().extras.state;
  }

  ngOnInit() {
  }

  public AvviaIncontro(): void {
    this.httpservice.AvviaIncontro();
    }

}
