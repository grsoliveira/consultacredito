import {Component, inject, OnInit} from '@angular/core';
import {CreditoService} from '../../services/credito';
import {Credito} from '../../models/credito.model';
import {CommonModule, CurrencyPipe, DatePipe} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-lista-credito.page',
  standalone: true,
  imports: [
    DatePipe,
    CurrencyPipe,
    RouterLink,
    CommonModule
  ],
  templateUrl: './lista-credito.page.html',
  styleUrl: './lista-credito.page.css'
})
export class ListaCreditoPage implements OnInit {
  private creditoService = inject(CreditoService);
  creditos: Credito[] = [];

  ngOnInit(): void {
    this.creditoService.listarCreditos().subscribe({
      next: (data) => this.creditos = data,
      error: (err) => console.error('Erro ao listar créditos', err)
    });
  }

}
