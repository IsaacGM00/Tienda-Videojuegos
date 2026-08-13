import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { BehaviorSubject } from 'rxjs';

export interface ItemCarrito {
  id: number;
  nombre: string;
  precio: number;
  imagen: string;
  cantidad: number;
  tipo: 'juegos' | 'mandos' | 'consolas';
}

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private items: ItemCarrito[] = [];
  private readonly itemsSubject = new BehaviorSubject<ItemCarrito[]>(this.items);
  items$ = this.itemsSubject.asObservable();

  constructor(@Inject(PLATFORM_ID) private readonly platformId: Object) {
    if (isPlatformBrowser(this.platformId)) {
      const data = localStorage.getItem('carrito');
      if (data) {
        this.items = JSON.parse(data);
        this.itemsSubject.next(this.items);
      }
    }
  }

  private save() {
    if (isPlatformBrowser(this.platformId)) {
      localStorage.setItem('carrito', JSON.stringify(this.items));
    }
    this.itemsSubject.next(this.items);
  }

  getItems() {
    return this.items;
  }

  addItem(item: ItemCarrito) {
    const existente = this.items.find(i => i.id === item.id && i.tipo === item.tipo);
    if (existente) {
      existente.cantidad++;
    } else {
      this.items.push({ ...item, cantidad: 1 });
    }
    this.save();
  }

  removeItem(id: number, tipo: string) {
    this.items = this.items.filter(i => !(i.id === id && i.tipo === tipo));
    this.save();
  }

  incrementar(id: number, tipo: string) {
    const item = this.items.find(i => i.id === id && i.tipo === tipo);
    if (item) {
      item.cantidad++;
      this.save();
    }
  }

  decrementar(id: number, tipo: string) {
    const item = this.items.find(i => i.id === id && i.tipo === tipo);
    if (item && item.cantidad > 1) {
      item.cantidad--;
      this.save();
    }
  }

  getTotal() {
    const total = this.items.reduce((acc, i) => acc + i.precio * i.cantidad, 0);
    return Number.parseFloat(total.toFixed(3)); // redondea a 3 decimales
  }

}
