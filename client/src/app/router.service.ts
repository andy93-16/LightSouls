import { Injectable } from '@angular/core';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(public router: Router) { }

  public RouteTo(url) {this.router.navigate(url); }

  }

