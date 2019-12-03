import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpclient: HttpClient, private router: Router) {
  }

  public IniziaNuovaPartita(): void {
      this.httpclient.get('http://localhost:8080/Modalita',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url])
      );
    }
  public ModalitaStoria(): void {
      this.httpclient.get('http://localhost:8080/ModalitaStoria',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url])
    );
    }
  public ProcediAdIncontro(): Observable<any> {
      return this.httpclient.get<any>('http://localhost:8080/ProcediAdIncontro') ;
    }
  public Termina(): void {
      this.httpclient.get('http://localhost:8080/Termina',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url]));
  }
  public AvviaIncontro(): void {
      this.httpclient.get('http://localhost:8080/AvviaIncontro',
        {responseType: 'text'}).subscribe(url => this.router.navigate([url]));
  }
  public RiepilogoEquipaggiamenti(): Observable<any[]> {
      return this.httpclient.get<any[]>( 'http://localhost:8080/RiepilogoEquipaggiamenti');
  }
  public SetPersonaggio(): void  {
      this.httpclient.get('http://localhost:8080/SetPersonaggio').subscribe();
  }
  public DettagliEquipaggiamento(id: number): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/DettagliEquipaggiamento/' + id,
      );
  }
  public Potenzia(id: number, diceColor: any): Observable<any>{
    return this.httpclient.post('http://localhost:8080/PotenziaEquipaggiamento',
      { equpaggiamentoid: id, TitaniteColor: diceColor},
      { responseType: 'text'});
  }


}
