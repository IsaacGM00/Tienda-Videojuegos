import { Component } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';

@Component({
  selector: 'app-juegos',
  imports: [Encabezado, Barra, Pie],
  templateUrl: './juegos.html',
  styleUrl: './juegos.css',
})
export class Juegos {}
