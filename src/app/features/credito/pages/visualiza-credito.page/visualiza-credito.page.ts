import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import {Credito} from '../../models/credito.model';
import {Router, RouterLink} from '@angular/router';

@Component({
  selector: 'app-visualiza-credito.page',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './visualiza-credito.page.html',
  styleUrl: './visualiza-credito.page.css'
})
export class VisualizaCreditoPage {
  credito: Credito | undefined;

  constructor(private router: Router) {
    this.credito = history.state['credito'];
  }
}
