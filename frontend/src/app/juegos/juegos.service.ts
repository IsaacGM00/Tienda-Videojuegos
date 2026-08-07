import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';

export interface Juego {
  id: number;
  consola: string;
  nombreJuego: string;
  precio: number;
  imagen: string;
}

@Injectable({
  providedIn: 'root'
})
export class JuegosService {
  private readonly apiUrl = 'http://localhost:8080/api/juegos';
  private juegosCache: Juego[] = []; // cache local

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Juego[]> {
    if (this.juegosCache.length > 0) {
      // si ya tenemos datos, los devolvemos sin pedir al backend
      return of(this.juegosCache);
    } else {
      // si no, pedimos al backend y guardamos en cache
      return this.http.get<Juego[]>(this.apiUrl).pipe(
        tap(data => this.juegosCache = data)
      );
    }
  }
}
