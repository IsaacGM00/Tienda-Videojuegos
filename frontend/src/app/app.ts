import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Encabezado } from './encabezado/encabezado';
import { Barra } from './barra/barra';
import { Carrusel } from './carrusel/carrusel';
import { Menu } from './menu/menu';
import { Pie } from './pie/pie';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Encabezado, Barra, Carrusel, Menu, Pie],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
