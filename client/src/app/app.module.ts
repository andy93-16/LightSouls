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
import { DettagliPotenziamentoComponent } from './dettagli-potenziamento/dettagli-potenziamento.component';
import { EquipaggiaPersonaggioComponent } from './equipaggia-personaggio/equipaggia-personaggio.component';
import { ChooseBodyPartComponent } from './choose-body-part/choose-body-part.component';
import { DettagliDepotenziamentoComponent } from './dettagli-depotenziamento/dettagli-depotenziamento.component';

const appRoutes: Routes = [
  { path: 'Giocatore', component: GiocatoreComponent },
  { path: 'Modalita' , component: ModalitaComponent},
  { path: 'Falo', component: FaloComponent},
  { path: 'Incontro', component: IncontroComponent},
  { path: 'RisultatoIncontro', component: RisultatoIncontroComponent},
  { path: 'RisultatoPartita', component: RisultatoPartitaComponent},
  { path: 'GestisciPersonaggio', component: GestisciPersonaggioComponent},
  { path: 'RiepilogoEquipaggiamenti', component: RiepilogoEquipaggiamentiComponent},
  { path: 'DettagliPotenziamento', component: DettagliPotenziamentoComponent},
  { path: 'EquipaggiaPersonaggio' , component: EquipaggiaPersonaggioComponent},
  { path: 'DettagliDepotenziamento', component: DettagliDepotenziamentoComponent},
  { path: 'ChooseBodyPart' , component: ChooseBodyPartComponent}
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
    DettagliPotenziamentoComponent,
    EquipaggiaPersonaggioComponent,
    ChooseBodyPartComponent,
    DettagliDepotenziamentoComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, { onSameUrlNavigation: 'reload'})],
  providers: [HttpService],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})

export class AppModule {

}
