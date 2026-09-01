import { Component, OnInit} from '@angular/core';
import { ConsolasService, Consola } from './consolas.service';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CarritoService } from '../carrito/carrito.service';

@Component({
  selector: 'app-consolas',
  imports: [Encabezado, Barra, Pie],
  templateUrl: './consolas.html',
  styleUrl: './consolas.css',
})
export class Consolas implements OnInit{
      consolas: Consola[] = [];
      consolasPlay: Consola[] = [];
      consolasXbox: Consola[] = [];
      consolasNintendo: Consola[] = [];

      constructor(
        private readonly consolaService: ConsolasService,
        private readonly carritoService: CarritoService
      ) {}

      ngOnInit(): void {
        this.consolaService.getAll().subscribe(data => {
          this.consolas = data;

          // Filtrar PlayStation Series
          this.consolasPlay = data.filter(c =>
            c.serieConsola === 'PlayStation Series'
          );

          // Filtrar Xbox Series
          this.consolasXbox = data.filter(c =>
            c.serieConsola === 'Xbox Series'
          );

          // Filtrar Nintendo Series
          this.consolasNintendo = data.filter(c =>
            c.serieConsola === 'Nintendo Series'
          );
        });
      }

      private getMarcaFolder(serieConsola: string): string {
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

      toasts: { mensaje: string, id: number }[] = [];
      private toastId = 0;

    agregarAlCarrito(consola: any) {
      const marcaFolder = this.getMarcaFolder(consola.serieConsola);
      this.carritoService.addItem({
        id: consola.id,
        nombre: consola.nombreConsola,
        precio: consola.precio,
        imagen: `assets/images/consolas/${marcaFolder}/${consola.imagen}`,
        cantidad: 1,
        tipo: 'consolas'
      });

      const mensaje = `✅ Se agregó "${consola.nombreConsola}" al carrito`;
      const id = ++this.toastId;
      this.toasts.push({ mensaje, id });

      // Eliminar este toast después de 3 segundos
      setTimeout(() => {
        this.toasts = this.toasts.filter(t => t.id !== id);
      }, 3000);
    }
}
