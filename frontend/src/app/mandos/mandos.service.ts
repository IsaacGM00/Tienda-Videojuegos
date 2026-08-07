import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';

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
  private mandosCache: Mando[] = [];

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Mando[]> {
    if (this.mandosCache.length > 0) {
      return of(this.mandosCache);
    } else {
      return this.http.get<Mando[]>(this.apiUrl).pipe(
        tap(data => this.mandosCache = data)
      );
    }
  }
}
