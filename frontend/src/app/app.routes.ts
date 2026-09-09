import { Routes } from '@angular/router';
import { Inicio } from './inicio/inicio';
import { Nosotros } from './nosotros/nosotros';
import { Juegos } from './juegos/juegos';
import { Mandos } from './mandos/mandos';
import { Consolas } from './consolas/consolas';
import { Carrito } from './carrito/carrito';
import { Usuarios } from './usuarios/usuarios';
import { JuegosDetalle } from './juegos-detalle/juegos-detalle';
import { MandosDetalle } from './mandos-detalle/mandos-detalle';
import { ConsolasDetalle } from './consolas-detalle/consolas-detalle';

export const routes: Routes = [
  { path: 'inicio', component: Inicio },
  { path: 'nosotros', component: Nosotros },
  { path: 'juegos', component: Juegos },
  { path: 'mandos', component: Mandos },
  { path: 'consolas', component: Consolas },
  { path: 'carrito', component: Carrito },
  { path: 'usuarios', component: Usuarios },
  { path: 'juegos/:id', component: JuegosDetalle},
  { path: 'mandos/:id', component: MandosDetalle},
  { path: 'consolas/:id', component: ConsolasDetalle},
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];
