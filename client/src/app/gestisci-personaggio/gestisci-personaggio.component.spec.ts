import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestisciPersonaggioComponent } from './gestisci-personaggio.component';

describe('GestisciPersonaggioComponent', () => {
  let component: GestisciPersonaggioComponent;
  let fixture: ComponentFixture<GestisciPersonaggioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestisciPersonaggioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestisciPersonaggioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
