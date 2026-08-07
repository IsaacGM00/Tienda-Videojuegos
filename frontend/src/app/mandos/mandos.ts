import { Component, OnInit} from '@angular/core';
import { MandosService, Mando } from './mandos.service';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CarritoService } from '../carrito/carrito.service';

@Component({
  selector: 'app-mandos',
  imports: [Encabezado, Barra, Pie],
  templateUrl: './mandos.html',
  styleUrl: './mandos.css',
})

export class Mandos implements OnInit{
    mandos: Mando[] = [];
    mandosPlay: Mando[] = [];
    mandosXbox: Mando[] = [];
    mandosNintendo: Mando[] = [];

    constructor(
      private readonly mandoService: MandosService,
      private readonly carritoService: CarritoService
    ) {}

    ngOnInit(): void {
      this.mandoService.getAll().subscribe(data => {
        this.mandos = data;

        // Filtrar PlayStation (incluye PS2, PS3, PS4)
        this.mandosPlay = data.filter(m =>
          m.consola === 'PlayStation' ||
          m.consola === 'PS2' ||
          m.consola === 'PS3' ||
          m.consola === 'PS4' ||
          m.consola === 'PS5'
        );

        // Filtrar Xbox (incluye Xbox 360, Xbox One)
        this.mandosXbox = data.filter(m =>
          m.consola === 'Xbox' ||
          m.consola === 'Xbox 360' ||
          m.consola === 'Xbox Series X' ||
          m.consola === 'Xbox One'
        );

        // Filtrar Nintendo (incluye Wii, Nintendo Switch)
        this.mandosNintendo = data.filter(m =>
          m.consola === 'Wii' ||
          m.consola === 'Nintendo Switch' ||
          m.consola === 'Nintendo Switch 2' ||
          m.consola === 'Game Boy' ||
          m.consola === 'Nintendo DS'
        );
      });
    }

    agregarAlCarrito(mando: any) {
      this.carritoService.addItem({
        id: mando.id,
        nombre: mando.nombreMando,
        precio: mando.precio,
        imagen: mando.imagen,
        cantidad: 1,
        tipo: 'mandos'
      });
    }
}
