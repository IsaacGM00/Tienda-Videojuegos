import { Component, OnInit } from '@angular/core';
import { JuegosService, Juego } from './juegos.service';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CarritoService } from '../carrito/carrito.service';

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

  constructor(
    private readonly juegoService: JuegosService,
    private readonly carritoService: CarritoService
  ) {}

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

  private getMarcaFolder(consola: string): string {
    consola = consola.toLowerCase();
    if (consola.includes('playstation') || consola.startsWith('ps')) {
      return 'playstation';
    }
    if (consola.includes('xbox')) {
      return 'xbox';
    }
    if (consola.includes('nintendo') || consola.includes('wii') || consola.includes('game boy') || consola.includes('ds') || consola.includes('switch')) {
      return 'nintendo';
    }
    return 'otros'; // fallback si no coincide
  }

  toasts: { mensaje: string, id: number }[] = [];
  private toastId = 0;

  agregarAlCarrito(juego: any) {
    const marcaFolder = this.getMarcaFolder(juego.consola);
    this.carritoService.addItem({
      id: juego.id,
      nombre: juego.nombreJuego,
      precio: juego.precio,
      imagen: `assets/images/juegos/${marcaFolder}/${juego.imagen}`,
      cantidad: 1,
      tipo: 'juegos'
    });

    const mensaje = `✅ Se agregó "${juego.nombreJuego}" al carrito`;
    const id = ++this.toastId;
    this.toasts.push({ mensaje, id });

    // Eliminar este toast después de 3 segundos
    setTimeout(() => {
      this.toasts = this.toasts.filter(t => t.id !== id);
    }, 3000);
  }

}
