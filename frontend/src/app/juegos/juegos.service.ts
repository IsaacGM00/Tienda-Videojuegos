import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Juego[]> {
    return this.http.get<Juego[]>(this.apiUrl);
  }
}
