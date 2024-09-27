import { Component, Input } from '@angular/core';
import { Egreso } from './egreso.model';
import { EgresoService } from './egreso.service';

@Component({
  selector: 'app-egreso',
  templateUrl: './egreso.component.html',
  styleUrl: './egreso.component.css'
})
export class EgresoComponent {
  egresos: Egreso[] = [];
  @Input() ingresoTotal: number;

  constructor(private egresoService: EgresoService) {
    this.egresos = this.egresoService.egresos;
  }

  eliminarRegistro(registro: Egreso) {
    this.egresoService.eliminar(registro);
  }

  calcularPorcentaje(egreso: Egreso) {
    return egreso.valor / this.ingresoTotal;
  }

}
