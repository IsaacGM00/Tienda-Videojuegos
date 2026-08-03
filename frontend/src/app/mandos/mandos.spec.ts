import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Mandos } from './mandos';

describe('Mandos', () => {
  let component: Mandos;
  let fixture: ComponentFixture<Mandos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Mandos],
    }).compileComponents();

    fixture = TestBed.createComponent(Mandos);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
