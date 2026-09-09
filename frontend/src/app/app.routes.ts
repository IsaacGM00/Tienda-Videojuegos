import { Routes } from '@angular/router';
import { Inicio } from './inicio/inicio';
import { Nosotros } from './nosotros/nosotros';
import { Juegos } from './juegos/juegos';
import { Mandos } from './mandos/mandos';
import { Consolas } from './consolas/consolas';
import { Carrito } from './carrito/carrito';
import { Usuarios } from './usuarios/usuarios';
import { JuegosDetalle } from './juegos-detalle/juegos-detalle';

export const routes: Routes = [
  { path: 'inicio', component: Inicio },
  { path: 'nosotros', component: Nosotros },
  { path: 'juegos', component: Juegos },
  { path: 'mandos', component: Mandos },
  { path: 'consolas', component: Consolas },
  { path: 'carrito', component: Carrito },
  { path: 'usuarios', component: Usuarios },
  { path: 'juegos/:id', component: JuegosDetalle},
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];
