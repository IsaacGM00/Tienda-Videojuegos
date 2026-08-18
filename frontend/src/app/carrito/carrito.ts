import { Component, OnInit} from '@angular/core';
import { CarritoService, ItemCarrito } from './carrito.service';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';

@Component({
  selector: 'app-carrito',
  standalone: true,
  imports: [Encabezado, Barra, Pie],
  templateUrl: './carrito.html',
  styleUrls: ['./carrito.css'],
})

export class Carrito implements OnInit{
  items: ItemCarrito[] = [];
  total: number = 0;

  constructor(private readonly carritoService: CarritoService) {}

  ngOnInit() {
    this.items = this.carritoService.getItems();
    this.total = this.carritoService.getTotal();
  }

  incrementar(item: ItemCarrito) {
    this.carritoService.incrementar(item.id, item.tipo);
    this.total = this.carritoService.getTotal();
  }

  decrementar(item: ItemCarrito) {
    this.carritoService.decrementar(item.id, item.tipo);
    this.total = this.carritoService.getTotal();
  }

  eliminar(item: ItemCarrito) {
    this.carritoService.removeItem(item.id, item.tipo);
    this.items = this.carritoService.getItems();
    this.total = this.carritoService.getTotal();
  }

}
