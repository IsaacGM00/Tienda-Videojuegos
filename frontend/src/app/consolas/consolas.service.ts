import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';

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
  private consolasCache: Consola[] = [];

  constructor(private readonly http: HttpClient) {}

  getAll(): Observable<Consola[]> {
    if (this.consolasCache.length > 0) {
      return of(this.consolasCache);
    } else {
      return this.http.get<Consola[]>(this.apiUrl).pipe(
        tap(data => this.consolasCache = data)
      );
    }
  }
}
