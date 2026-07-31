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
  juegosPlay: Juego[] = [];
  juegosXbox: Juego[] = [];
  juegosNintendo: Juego[] = [];

  constructor(private readonly juegoService: JuegosService) {}

  ngOnInit(): void {
    this.juegoService.getAll().subscribe(data => {
      this.juegos = data;

      // Filtrar PlayStation (incluye PS2, PS3, PS4)
      this.juegosPlay = data.filter(j =>
        j.consola === 'PlayStation' ||
        j.consola === 'PS2' ||
        j.consola === 'PS3' ||
        j.consola === 'PS4' ||
        j.consola === 'PS5'
      );

      // Filtrar Xbox (incluye Xbox 360, Xbox One)
      this.juegosXbox = data.filter(j =>
        j.consola === 'Xbox' ||
        j.consola === 'Xbox 360' ||
        j.consola === 'Xbox Series X' ||
        j.consola === 'Xbox One'
      );

      // Filtrar Nintendo (incluye Wii, Nintendo Switch)
      this.juegosNintendo = data.filter(j =>
        j.consola === 'Wii' ||
        j.consola === 'Nintendo Switch' ||
        j.consola === 'Nintendo Switch 2' ||
        j.consola === 'Game Boy' ||
        j.consola === 'Nintendo DS'
      );
    });
  }
}
