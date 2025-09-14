import {Component, inject, OnInit} from '@angular/core';
import {CreditoService} from '../../services/credito.service';
import {Credito} from '../../models/credito.model';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-busca-credito.page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './busca-credito.page.html',
  styleUrl: './busca-credito.page.css'
})
export class BuscaCreditoPage implements OnInit {

  private creditoService = inject(CreditoService);

  termoBusca: string = '';
  tipoBusca: 'numeroCredito' | 'numeroNfse' = 'numeroCredito';
  creditos: Credito[] = [];

  ngOnInit(): void {
    this.resetBusca();
  }

  resetBusca() {
    this.termoBusca = '';
    this.tipoBusca = 'numeroCredito';
    this.creditos = [];
  }

  buscar() {
    const termo = this.termoBusca.trim();
    if (!termo) return;

    if (this.tipoBusca === 'numeroCredito') {
      this.creditoService.buscarPorNumeroCredito(termo).subscribe({
        next: (credito) => {
          this.creditos = credito ? [credito] : [];
        },
        error: (err) => {
          console.error('Erro na busca por número de crédito', err);
          this.creditos = [];
        }
      });
    } else {
      this.creditoService.buscarPorNumeroNfse(termo).subscribe({
        next: (lista) => {
          this.creditos = lista;
          console.log(lista);
        },
        error: (err) => {
          console.error('Erro na busca por NFS-e', err);
          this.creditos = [];
        }
      });
    }
  }

}
