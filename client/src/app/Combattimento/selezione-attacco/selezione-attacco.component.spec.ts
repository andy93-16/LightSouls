import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelezioneAttaccoComponent } from './selezione-attacco.component';

describe('SelezioneAttaccoComponent', () => {
  let component: SelezioneAttaccoComponent;
  let fixture: ComponentFixture<SelezioneAttaccoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelezioneAttaccoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelezioneAttaccoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
