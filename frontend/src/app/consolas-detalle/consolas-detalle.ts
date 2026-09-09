import { Component, OnInit } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CommonModule } from '@angular/common';
import { Consola, ConsolasService } from '../consolas/consolas.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-consolas-detalle',
  imports: [CommonModule, Encabezado, Barra, Pie],
  templateUrl: './consolas-detalle.html',
  styleUrl: './consolas-detalle.css',
})
export class ConsolasDetalle implements OnInit{
  consola?: Consola;
    constructor(
    private readonly route: ActivatedRoute,
    private readonly consolasService: ConsolasService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.consolasService.getAll().subscribe(data => {
      this.consola = data.find(j => j.id === id);
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
}
