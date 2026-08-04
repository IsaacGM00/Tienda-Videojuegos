import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Consolas } from './consolas';

describe('Consolas', () => {
  let component: Consolas;
  let fixture: ComponentFixture<Consolas>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Consolas],
    }).compileComponents();

    fixture = TestBed.createComponent(Consolas);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
