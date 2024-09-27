import { Component } from '@angular/core';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrl: './persona.component.css'
})
export class PersonaComponent {
  nombre: string = "Juan";
  apellido: string = "Perez";
  // private edad: number = 28;
  edad: number = 28;

  // getEdad(){
  //   return this.edad;
  // }

}
