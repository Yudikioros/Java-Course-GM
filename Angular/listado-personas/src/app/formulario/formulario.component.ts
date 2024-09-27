import { Component, ElementRef, ViewChild } from '@angular/core';
import { Persona } from '../persona.model';
import { PersonasService } from '../personas.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  nombreInput: string = '';
  apellidoInput: string = '';

  //Dependency Injection
  constructor(private personasService: PersonasService) {
    this.personasService.saludar.subscribe((indice) => {
      alert("El indice es " + indice)
    });
  }

  mensaje: string = '';

  // @Output() personaCreada = new EventEmitter<Persona>();

  agregarPersona() {
    if (
      this.nombreInput === '' ||
      this.apellidoInput === ''
    ) {
      this.mensaje = 'Por favor, rellene todos los campos';
    } else {
      // this.personaCreada.emit(
      //   new Persona(
      //     this.nombreInput.nativeElement.value,
      //     this.apellidoInput.nativeElement.value
      //   )
      // );
      this.personasService.agregarPersona(
        new Persona(
          this.nombreInput,
          this.apellidoInput
        )
      );
      this.mensaje = '';
    }
  }
}
