import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RouterService} from "./router.service";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpclient: HttpClient, private routerservice: RouterService) {
  }

  public IniziaNuovaPartita() {
      this.httpclient.get('http://localhost:8080/Modalita',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo(url)
      );
    }
  public ModalitaStoria() {
      this.httpclient.get('http://localhost:8080/ModalitaStoria',
        {responseType: 'text'}).subscribe(url => this.routerservice.RouteTo(url)
    );
    }
  public AvviaIncontro(incontroCorrente) {
      this.httpclient.get('http://localhost:8080/AvviaIncontro',
        {responseType: 'text'}).subscribe(incontro => incontroCorrente);
    }
}
