import { Component } from '@angular/core';
import { Ingreso } from './ingreso.model';
import { IngresoService } from './ingreso.service';

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styleUrl: './ingreso.component.css'
})
export class IngresoComponent {
  ingresos:Ingreso[] = [];
  constructor(private ingresoService: IngresoService) {
    this.ingresos = this.ingresoService.ingresos;
  }

  eliminarRegistro(registro: Ingreso) {
    this.ingresoService.eliminar(registro);
  }

}
