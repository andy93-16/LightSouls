import { Component, OnInit } from '@angular/core';
import {HttpService} from '../http.service';

@Component({
  selector: 'app-incontro',
  templateUrl: './incontro.component.html',
  styleUrls: ['./incontro.component.css']
})
export class IncontroComponent implements OnInit {

  incontroCorrente: any;

  constructor(private httpservice: HttpService) {}

  ngOnInit() {
    this.httpservice.ProcediAdIncontro().subscribe( incontro => {
          this.incontroCorrente = incontro; });
  }

  public AvviaIncontro(): void {
    this.httpservice.AvviaIncontro();
    }

}
