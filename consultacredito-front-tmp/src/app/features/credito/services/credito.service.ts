import {inject, Injectable} from '@angular/core';
import {Credito} from '../models/credito.model';
import {Observable} from 'rxjs';
import {API_CONFIG} from '../../../config/api.config';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreditoService {
  private http = inject(HttpClient);
  private baseUrl = API_CONFIG.baseUrl;

  constructor() {}

  listarCreditos(): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.baseUrl}/creditos`);
  }

  buscarPorNumeroCredito(numeroCredito: string): Observable<Credito | null> {
    return this.http.get<Credito>(`${this.baseUrl}/creditos/credito/${numeroCredito}`);
  }

  buscarPorNumeroNfse(numeroNfse: string): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.baseUrl}/creditos/${numeroNfse}`);
  }
}
