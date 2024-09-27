import { EventEmitter, Injectable } from '@angular/core';
import { LoggingService } from './LoggingService.service';
import { Persona } from './persona.model';

// Utilizar un servicio dentro de otro servicio
@Injectable()
export class PersonasService {
  personas: Persona[] = [
    new Persona('Juan', 'Perez'),
    new Persona('Carlos', 'Lara'),
    new Persona('Luis', 'Juarez'),
  ];
  saludar = new EventEmitter<number>();

  constructor(private loggingService: LoggingService) {}


  agregarPersona(persona: Persona) {
    this.loggingService.enviarMensajeAConsola('Agregando persona');
    this.personas.push(persona);
  }

}
