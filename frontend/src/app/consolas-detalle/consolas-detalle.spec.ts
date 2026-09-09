import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsolasDetalle } from './consolas-detalle';

describe('ConsolasDetalle', () => {
  let component: ConsolasDetalle;
  let fixture: ComponentFixture<ConsolasDetalle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsolasDetalle],
    }).compileComponents();

    fixture = TestBed.createComponent(ConsolasDetalle);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
