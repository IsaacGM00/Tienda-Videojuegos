import { Component, OnInit } from '@angular/core';
import { JuegosService, Juego } from './juegos.service';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';

@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.html',
  imports: [Encabezado, Barra, Pie],
  styleUrls: ['./juegos.css']
})
export class Juegos implements OnInit {
  juegos: Juego[] = [];

  constructor(private readonly juegoService: JuegosService) {}

  ngOnInit(): void {
    this.juegoService.getAll().subscribe(data => {
      this.juegos = data;
    });
  }
}
