import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GiocatoreComponent } from './giocatore/giocatore.component';
import {HttpClientModule} from '@angular/common/http';
import {HttpService} from './http.service';
import { ModalitaComponent } from './modalita/modalita.component';
import { FaloComponent } from './falo/falo.component';
import { RiepilogoIncontroComponent } from './Combattimento/riepilogo-incontro/riepilogo-incontro.component';
import { RisultatoIncontroComponent } from './Combattimento/risultato-incontro/risultato-incontro.component';
import { RisultatoPartitaComponent } from './risultato-partita/risultato-partita.component';
import { GestisciPersonaggioComponent } from './gestisci-personaggio/gestisci-personaggio.component';
import { RiepilogoEquipaggiamentiComponent } from './Potenziamento/riepilogo-equipaggiamenti/riepilogo-equipaggiamenti.component';
import { DettagliPotenziamentoComponent } from './Potenziamento/dettagli-potenziamento/dettagli-potenziamento.component';
import { EquipaggiaPersonaggioComponent } from './CambioEquipaggiamento/equipaggia-personaggio/equipaggia-personaggio.component';
import { ChooseBodyPartComponent } from './CambioEquipaggiamento/choose-body-part/choose-body-part.component';
import { DettagliDepotenziamentoComponent } from './Potenziamento/dettagli-depotenziamento/dettagli-depotenziamento.component';
import { TurnoNemicoComponent } from './Combattimento/turno-nemico/turno-nemico.component';
import { TurnoPersonaggioComponent } from './Combattimento/turno-personaggio/turno-personaggio.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { SelezioneAttaccoComponent } from './Combattimento/selezione-attacco/selezione-attacco.component';

const appRoutes: Routes = [
  { path: 'Giocatore', component: GiocatoreComponent },
  { path: 'Modalita' , component: ModalitaComponent},
  { path: 'Falo', component: FaloComponent},
  { path: 'RiepilogoIncontro', component: RiepilogoIncontroComponent},
  { path: 'RisultatoIncontro', component: RisultatoIncontroComponent},
  { path: 'RisultatoPartita', component: RisultatoPartitaComponent},
  { path: 'GestisciPersonaggio', component: GestisciPersonaggioComponent},
  { path: 'RiepilogoEquipaggiamenti', component: RiepilogoEquipaggiamentiComponent},
  { path: 'DettagliPotenziamento/:posizione', component: DettagliPotenziamentoComponent},
  { path: 'EquipaggiaPersonaggio' , component: EquipaggiaPersonaggioComponent , runGuardsAndResolvers: 'always'},
  { path: 'DettagliDepotenziamento/:posizione', component: DettagliDepotenziamentoComponent},
  { path: 'ChooseBodyPart' , component: ChooseBodyPartComponent},
  { path: 'TurnoPersonaggio', component: TurnoPersonaggioComponent},
  { path: 'TurnoNemico', component: TurnoNemicoComponent},
  { path: 'SelezioneAttacco', component: SelezioneAttaccoComponent},
  { path: '**', component: GiocatoreComponent }
  ];

@NgModule({
  declarations: [
    AppComponent,
    GiocatoreComponent,
    ModalitaComponent,
    FaloComponent,
    RiepilogoIncontroComponent,
    RisultatoIncontroComponent,
    RisultatoPartitaComponent,
    GestisciPersonaggioComponent,
    RiepilogoEquipaggiamentiComponent,
    DettagliPotenziamentoComponent,
    EquipaggiaPersonaggioComponent,
    ChooseBodyPartComponent,
    DettagliDepotenziamentoComponent,
    TurnoNemicoComponent,
    TurnoPersonaggioComponent,
    SelezioneAttaccoComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, { onSameUrlNavigation:'reload'}),
    NoopAnimationsModule],
  providers: [HttpService],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})

export class AppModule {

}
