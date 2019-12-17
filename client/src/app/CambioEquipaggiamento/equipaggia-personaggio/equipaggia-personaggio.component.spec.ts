import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipaggiaPersonaggioComponent } from './equipaggia-personaggio.component';

describe('EquipaggiaPersonaggioComponent', () => {
  let component: EquipaggiaPersonaggioComponent;
  let fixture: ComponentFixture<EquipaggiaPersonaggioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipaggiaPersonaggioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipaggiaPersonaggioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
