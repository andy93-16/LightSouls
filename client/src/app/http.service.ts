import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
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
    return this.httpclient.get('http://localhost:8080/PotenziaEquipaggiamento/'
      + id + '&' + diceColor,
      { responseType: 'text'});
  }
  public RiepilogoEquipaggiati(): Observable<any> {
    return this.httpclient.get('http://localhost:8080/RiepilogoEquipaggiati');
  }
  public RiepilogoEquipaggiabili(id: number): Observable<any[]> {
    return this.httpclient.get<any[]>('http://localhost:8080/RiepilogoEquipaggiabili/' + id);
  }
  public Scambia(equipaggiamentoOutId: number, equipaggiamentoInId: number): Observable<any> {
    return this.httpclient.get('http://localhost:8080/Scambia/' + equipaggiamentoOutId + '&' + equipaggiamentoInId,
      { responseType: 'text'});
  }


}
