import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GiocatoreComponent } from './giocatore/giocatore.component';
import {HttpClientModule} from "@angular/common/http";
import {HttpService} from "./http.service";
import { ModalitaComponent } from './modalita/modalita.component';
import { FaloComponent } from './falo/falo.component';

const appRoutes: Routes = [
  { path: 'Giocatore', component: GiocatoreComponent },
  { path: 'Modalita' , component: ModalitaComponent},
  { path: 'Falo', component:FaloComponent}
//  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    GiocatoreComponent,
    ModalitaComponent,
    FaloComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)],
  providers: [HttpService],
  bootstrap: [AppComponent],
  exports:[RouterModule]
})
export class AppModule { }
