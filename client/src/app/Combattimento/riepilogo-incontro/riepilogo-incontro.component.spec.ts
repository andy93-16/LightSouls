import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RiepilogoIncontroComponent } from './riepilogo-incontro.component';

describe('RiepilogoIncontroComponent', () => {
  let component: RiepilogoIncontroComponent;
  let fixture: ComponentFixture<RiepilogoIncontroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RiepilogoIncontroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RiepilogoIncontroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
