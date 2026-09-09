import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JuegosDetalle } from './juegos-detalle';

describe('JuegosDetalle', () => {
  let component: JuegosDetalle;
  let fixture: ComponentFixture<JuegosDetalle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JuegosDetalle],
    }).compileComponents();

    fixture = TestBed.createComponent(JuegosDetalle);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
