import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrl: './resultado.component.css',
})
export class ResultadoComponent {
  @Input() resultadoHijo: number;
  mensaje: string = '';

  isNumber(number: number) {
    if (isNaN(number) || number == null) {
      this.mensaje = 'El resultado no es un número';
      return false;
    }
    return true;
  }
}
