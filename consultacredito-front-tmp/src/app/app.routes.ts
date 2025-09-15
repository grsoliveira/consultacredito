import { Routes } from '@angular/router';
import {ListaCreditoPage} from './features/credito/pages/lista-credito.page/lista-credito.page';
import {BuscaCreditoPage} from './features/credito/pages/busca-credito.page/busca-credito.page';
import {VisualizaCreditoPage} from './features/credito/pages/visualiza-credito.page/visualiza-credito.page';

export const routes: Routes = [
  { path: '', component: ListaCreditoPage },
  { path: 'busca', component: BuscaCreditoPage },
  { path: 'visualiza', component: VisualizaCreditoPage },
  { path: '**', redirectTo: '' }
];
