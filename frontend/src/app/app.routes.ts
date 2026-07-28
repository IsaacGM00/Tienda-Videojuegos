import { Routes } from '@angular/router';
import { Inicio } from './inicio/inicio';
import { Nosotros } from './nosotros/nosotros';
import { Juegos } from './juegos/juegos';

export const routes: Routes = [
  { path: 'inicio', component: Inicio },
  { path: 'nosotros', component: Nosotros },
  { path: 'juegos', component: Juegos},
  { path: '', redirectTo: '/inicio', pathMatch: 'full' }
];
