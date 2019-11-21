import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncontroComponent } from './incontro.component';

describe('IncontroComponent', () => {
  let component: IncontroComponent;
  let fixture: ComponentFixture<IncontroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncontroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncontroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
