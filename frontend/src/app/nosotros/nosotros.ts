import { Component } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';

@Component({
  selector: 'app-nosotros',
  imports: [Encabezado, Barra, Pie],
  templateUrl: './nosotros.html',
  styleUrl: './nosotros.css',
})
export class Nosotros {}
