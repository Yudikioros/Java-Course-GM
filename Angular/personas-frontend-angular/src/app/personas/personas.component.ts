import { Component } from '@angular/core';
import { Persona } from '../persona.model';
import { PersonaService } from '../persona-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styles: ``
})
export class PersonasComponent{
  personas: Persona[] = [];

  constructor(private personaServicio: PersonaService, private enrutador: Router){}

  ngOnInit(): void{
    console.log("Obteniendo personas");
    this.obtenerPersonas();
  }

  private obtenerPersonas(){
    this.personaServicio.obtenerPersonasLista().subscribe(
      (datos => {
        this.personas = datos;
        console.log(this.personas);
      })
    );
  }

  irAgregar(){
    console.log('nos vamos a agregar');
    this.enrutador.navigate(['./personas/agregar']);
  }

}
