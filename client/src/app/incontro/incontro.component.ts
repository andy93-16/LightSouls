import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-incontro',
  templateUrl: './incontro.component.html',
  styleUrls: ['./incontro.component.css']
})
export class IncontroComponent implements OnInit {

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
