import { Component } from '@angular/core';
import { EgresoService } from '../egreso/egreso.service';
import { IngresoService } from '../ingreso/ingreso.service';
import { Ingreso } from '../ingreso/ingreso.model';
import { Egreso } from '../egreso/egreso.model';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  tipo: string = 'ingresoOperacion';
  descripcionInput: string;
  valorInput: number;

  constructor(
    private egresoService: EgresoService,
    private ingresoService: IngresoService
  ) {}

  tipoOperacion(event: any) {
    this.tipo = event.target.value;
  }

  agregarRegistro() {
    if (this.tipo === 'ingresoOperacion') {
      this.ingresoService.ingresos.push(
        new Ingreso(this.descripcionInput, this.valorInput)
      );
    } else {
      this.egresoService.egresos.push(
        new Egreso(this.descripcionInput, this.valorInput)
      );
    }
  }
}
