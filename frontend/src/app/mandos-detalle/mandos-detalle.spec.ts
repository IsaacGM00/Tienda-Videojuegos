import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MandosDetalle } from './mandos-detalle';

describe('MandosDetalle', () => {
  let component: MandosDetalle;
  let fixture: ComponentFixture<MandosDetalle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MandosDetalle],
    }).compileComponents();

    fixture = TestBed.createComponent(MandosDetalle);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
