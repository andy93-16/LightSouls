import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FaloComponent } from './falo.component';

describe('FaloComponent', () => {
  let component: FaloComponent;
  let fixture: ComponentFixture<FaloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FaloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FaloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
