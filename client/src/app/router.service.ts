import { Injectable } from '@angular/core';
import {Router, Routes} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }

  public RouteTo(url) {this.router.navigate([url]);}

  }

