import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GiocatoreComponent } from './giocatore/giocatore.component';
import {HttpClientModule} from '@angular/common/http';
import {HttpService} from './http.service';
import { ModalitaComponent } from './modalita/modalita.component';
import { FaloComponent } from './falo/falo.component';
import { IncontroComponent } from './incontro/incontro.component';
import { RisultatoIncontroComponent } from './risultato-incontro/risultato-incontro.component';
import { RisultatoPartitaComponent } from './risultato-partita/risultato-partita.component';
import { GestisciPersonaggioComponent } from './gestisci-personaggio/gestisci-personaggio.component';
import { RiepilogoEquipaggiamentiComponent } from './riepilogo-equipaggiamenti/riepilogo-equipaggiamenti.component';
import { DettagliEquipaggiamentoComponent } from './dettagli-equipaggiamento/dettagli-equipaggiamento.component';

const appRoutes: Routes = [
  { path: 'Giocatore', component: GiocatoreComponent },
  { path: 'Modalita' , component: ModalitaComponent},
  { path: 'Falo', component: FaloComponent},
  { path: 'Incontro', component: IncontroComponent},
  { path: 'RisultatoIncontro', component: RisultatoIncontroComponent},
  { path: 'RisultatoPartita', component: RisultatoPartitaComponent},
  { path: 'GestisciPersonaggio', component: GestisciPersonaggioComponent},
  { path: 'RiepilogoEquipaggiamenti', component: RiepilogoEquipaggiamentiComponent},
  { path: 'DettagliEquipaggiamento', component: DettagliEquipaggiamentoComponent}
//  { path: '**', component: PageNotFoundComponent }
  ];

@NgModule({
  declarations: [
    AppComponent,
    GiocatoreComponent,
    ModalitaComponent,
    FaloComponent,
    IncontroComponent,
    RisultatoIncontroComponent,
    RisultatoPartitaComponent,
    GestisciPersonaggioComponent,
    RiepilogoEquipaggiamentiComponent,
    DettagliEquipaggiamentoComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)],
  providers: [HttpService],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule{

}
