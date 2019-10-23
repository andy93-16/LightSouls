import { Component, OnInit } from '@angular/core';
import {HttpService} from "../http.service";

@Component({
  selector: 'app-modalita',
  templateUrl: './modalita.component.html',
  styleUrls: ['./modalita.component.css']
})
export class ModalitaComponent implements OnInit {

  constructor(private httpservice:HttpService) { }

  ModalitaStoria():void{
    this.httpservice.ModalitaStoria()

  }

  ngOnInit() {
  }

}
