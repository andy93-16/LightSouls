import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RisultatoIncontroComponent } from './risultato-incontro.component';

describe('RisultatoIncontroComponent', () => {
  let component: RisultatoIncontroComponent;
  let fixture: ComponentFixture<RisultatoIncontroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RisultatoIncontroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RisultatoIncontroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
