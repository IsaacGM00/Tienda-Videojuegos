import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Mando {
  id: number;
  consola: string;
  nombreMando: string;
  precio: number;
  imagen: string;
}

@Injectable({
  providedIn: 'root'
})
export class MandosService {
  private readonly apiUrl = 'http://localhost:8080/api/mandos';

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Mando[]> {
    return this.http.get<Mando[]>(this.apiUrl);
  }
}
