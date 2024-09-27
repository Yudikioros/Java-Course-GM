import { Component } from '@angular/core';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css'],
  styles: [
    `
      h1 {
        color: blue;
      }
    `,
  ],
})
export class PersonasComponent {
  deshabilitar = false;
  mensaje = 'No se ha agregado ninguna persona';
  titulo = 'Sin titulo';
  mostrar = false;

  agregarPersona() {
    this.mensaje = 'Se ha agregado una persona';
    this.mostrar = true;
    // this.deshabilitar = true;
  }
}
