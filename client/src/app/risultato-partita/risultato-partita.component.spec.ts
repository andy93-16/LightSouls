import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RisultatoPartitaComponent } from './risultato-partita.component';

describe('RisultatoPartitaComponent', () => {
  let component: RisultatoPartitaComponent;
  let fixture: ComponentFixture<RisultatoPartitaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RisultatoPartitaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RisultatoPartitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
