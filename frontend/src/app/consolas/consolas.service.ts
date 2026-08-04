import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Consola {
  id: number;
  serieConsola: string;
  nombreConsola: string;
  precio: number;
  imagen: string;
}

@Injectable({
  providedIn: 'root'
})
export class ConsolasService {
  private readonly apiUrl = 'http://localhost:8080/api/consolas';

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Consola[]> {
    return this.http.get<Consola[]>(this.apiUrl);
  }
}
