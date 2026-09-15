import { Component, OnInit } from '@angular/core';
import { Juego, JuegosService } from '../juegos/juegos.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CarritoService } from '../carrito/carrito.service';

@Component({
  selector: 'app-juegos-detalle',
  imports: [CommonModule, Encabezado, Barra, Pie],
  templateUrl: './juegos-detalle.html',
  styleUrl: './juegos-detalle.css',
})
export class JuegosDetalle implements OnInit {
  juego?: Juego;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly juegosService: JuegosService,
    private readonly carritoService: CarritoService,
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.juegosService.getAll().subscribe((data) => {
      this.juego = data.find((j) => j.id === id);
    });
  }

  getMarcaFolder(consola: string): string {
    consola = consola.toLowerCase();
    if (consola.includes('playstation') || consola.startsWith('ps')) {
      return 'playstation';
    }
    if (consola.includes('xbox')) {
      return 'xbox';
    }
    if (
      consola.includes('nintendo') ||
      consola.includes('wii') ||
      consola.includes('game boy') ||
      consola.includes('ds') ||
      consola.includes('switch')
    ) {
      return 'nintendo';
    }
    return 'otros'; // fallback si no coincide
  }

  toasts: { mensaje: string; id: number }[] = [];
  private toastId = 0;

  agregarAlCarrito(juego: any) {
    const marcaFolder = this.getMarcaFolder(juego.consola);
    this.carritoService.addItem({
      id: juego.id,
      nombre: juego.nombreJuego,
      precio: juego.precio,
      imagen: `assets/images/juegos/${marcaFolder}/${juego.imagen}`,
      cantidad: 1,
      tipo: 'juegos',
    });

    const mensaje = `✅ Se agregó "${juego.nombreJuego}" al carrito`;
    const id = ++this.toastId;
    this.toasts.push({ mensaje, id });

    // Eliminar este toast después de 3 segundos
    setTimeout(() => {
      this.toasts = this.toasts.filter((t) => t.id !== id);
    }, 3000);
  }
}
