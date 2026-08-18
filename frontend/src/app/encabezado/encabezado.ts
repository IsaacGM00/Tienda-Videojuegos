import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";
import { CarritoService, ItemCarrito } from '../carrito/carrito.service';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-encabezado',
  standalone: true,
  imports: [RouterLink, AsyncPipe],
  templateUrl: './encabezado.html',
  styleUrl: './encabezado.css',
})
export class Encabezado {
  items$: Observable<ItemCarrito[]>;

  constructor(private readonly carritoService: CarritoService) {
    this.items$ = this.carritoService.items$;
  }

  getCantidadTotal(items: ItemCarrito[] | null): number {
    if (!items) return 0;
    return items.reduce((acc, i) => acc + i.cantidad, 0);
  }
}
