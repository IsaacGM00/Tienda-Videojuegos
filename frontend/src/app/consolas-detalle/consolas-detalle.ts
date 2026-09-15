import { Component, OnInit } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CommonModule } from '@angular/common';
import { Consola, ConsolasService } from '../consolas/consolas.service';
import { ActivatedRoute } from '@angular/router';
import { CarritoService } from '../carrito/carrito.service';

@Component({
  selector: 'app-consolas-detalle',
  imports: [CommonModule, Encabezado, Barra, Pie],
  templateUrl: './consolas-detalle.html',
  styleUrl: './consolas-detalle.css',
})
export class ConsolasDetalle implements OnInit {
  consola?: Consola;
  constructor(
    private readonly route: ActivatedRoute,
    private readonly consolasService: ConsolasService,
    private readonly carritoService: CarritoService,
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.consolasService.getAll().subscribe((data) => {
      this.consola = data.find((j) => j.id === id);
    });
  }

  getMarcaFolder(serieConsola: string): string {
    serieConsola = serieConsola.toLowerCase();
    if (serieConsola.includes('playstation')) {
      return 'playstation';
    }
    if (serieConsola.includes('xbox')) {
      return 'xbox';
    }
    if (serieConsola.includes('nintendo')) {
      return 'nintendo';
    }
    return 'otros'; // fallback si no coincide
  }

  toasts: { mensaje: string; id: number }[] = [];
  private toastId = 0;

  agregarAlCarrito(consola: any) {
    const marcaFolder = this.getMarcaFolder(consola.serieConsola);
    this.carritoService.addItem({
      id: consola.id,
      nombre: consola.nombreConsola,
      precio: consola.precio,
      imagen: `assets/images/consolas/${marcaFolder}/${consola.imagen}`,
      cantidad: 1,
      tipo: 'consolas',
    });

    const mensaje = `✅ Se agregó "${consola.nombreConsola}" al carrito`;
    const id = ++this.toastId;
    this.toasts.push({ mensaje, id });

    // Eliminar este toast después de 3 segundos
    setTimeout(() => {
      this.toasts = this.toasts.filter((t) => t.id !== id);
    }, 3000);
  }
}
