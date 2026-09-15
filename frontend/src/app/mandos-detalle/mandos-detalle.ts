import { Component, OnInit } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CommonModule } from '@angular/common';
import { Mando, MandosService } from '../mandos/mandos.service';
import { ActivatedRoute } from '@angular/router';
import { CarritoService } from '../carrito/carrito.service';

@Component({
  selector: 'app-mandos-detalle',
  imports: [CommonModule, Encabezado, Barra, Pie],
  templateUrl: './mandos-detalle.html',
  styleUrl: './mandos-detalle.css',
})
export class MandosDetalle implements OnInit {
  mando?: Mando;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly mandosService: MandosService,
    private readonly carritoService: CarritoService,
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.mandosService.getAll().subscribe((data) => {
      this.mando = data.find((j) => j.id === id);
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

  agregarAlCarrito(mando: any) {
    const marcaFolder = this.getMarcaFolder(mando.consola);
    this.carritoService.addItem({
      id: mando.id,
      nombre: mando.nombreMando,
      precio: mando.precio,
      imagen: `assets/images/mandos/${marcaFolder}/${mando.imagen}`,
      cantidad: 1,
      tipo: 'mandos',
    });

    const mensaje = `✅ Se agregó "${mando.nombreMando}" al carrito`;
    const id = ++this.toastId;
    this.toasts.push({ mensaje, id });

    // Eliminar este toast después de 3 segundos
    setTimeout(() => {
      this.toasts = this.toasts.filter((t) => t.id !== id);
    }, 3000);
  }
}
