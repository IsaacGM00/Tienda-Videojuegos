import { Component, OnInit } from '@angular/core';
import { Encabezado } from '../encabezado/encabezado';
import { Barra } from '../barra/barra';
import { Pie } from '../pie/pie';
import { CommonModule } from '@angular/common';
import { Mando, MandosService } from '../mandos/mandos.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-mandos-detalle',
  imports: [CommonModule, Encabezado, Barra, Pie],
  templateUrl: './mandos-detalle.html',
  styleUrl: './mandos-detalle.css',
})
export class MandosDetalle implements OnInit{
  mando?: Mando;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly mandosService: MandosService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.mandosService.getAll().subscribe(data => {
      this.mando = data.find(j => j.id === id);
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
    if (consola.includes('nintendo') || consola.includes('wii') || consola.includes('game boy') || consola.includes('ds') || consola.includes('switch')) {
      return 'nintendo';
    }
    return 'otros'; // fallback si no coincide
  }
}
