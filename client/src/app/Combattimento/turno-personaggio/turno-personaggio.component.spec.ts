import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TurnoPersonaggioComponent } from './turno-personaggio.component';

describe('TurnoPersonaggioComponent', () => {
  let component: TurnoPersonaggioComponent;
  let fixture: ComponentFixture<TurnoPersonaggioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TurnoPersonaggioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TurnoPersonaggioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
