import { Component } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Carrusel } from '../carrusel/carrusel';
import { Menu } from '../menu/menu';
import { Pie } from '../pie/pie';

@Component({
  selector: 'app-inicio',
  imports: [Encabezado, Barra, Carrusel, Menu, Pie],
  templateUrl: './inicio.html',
  styleUrl: './inicio.css',
})
export class Inicio {}
