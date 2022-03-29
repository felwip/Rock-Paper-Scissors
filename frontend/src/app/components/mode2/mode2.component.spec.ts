import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Mode2Component } from './mode2.component';

describe('Mode2Component', () => {
  let component: Mode2Component;
  let fixture: ComponentFixture<Mode2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Mode2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Mode2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
