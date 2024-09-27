import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../persona-service';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from '../persona.model';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styles: ``,
})
export class FormularioComponent implements OnInit {
  nombreInput: string = '';
  idPersona: number = 0;

  constructor(
    private personaService: PersonaService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    // Nos suscribimos a los cambios en los parámetros de la URL
    this.route.params.subscribe(params => {
      this.idPersona = params['idPersona'];
      console.log('Nuevo idPersona detectado:' + this.idPersona);

      if (this.idPersona != null) {
        this.personaService.encontrarPersona(this.idPersona).subscribe({
          next: (datos) => {
            this.nombreInput = datos.nombre;
            console.log(this.nombreInput);
          },
          error: (error: any) => console.log(error),
        });
      }
    });
  }

  onGuardarPersona() {
    let personaAGuardar = new Persona(this.idPersona, this.nombreInput);
    if (this.idPersona != null) {
      this.personaService
        .modificarPersona(this.idPersona, personaAGuardar)
        .subscribe({
          next: () => this.router.navigate(['']),
        });
    } else {
      console.log('Agregando persona');
      this.personaService.agregarPersona(personaAGuardar).subscribe({
        next: () => this.router.navigate(['']),
      });
    }
  }

  onEliminarPersona() {
    if (this.idPersona != null) {
      console.log('persona a eliminar:' + this.idPersona);
      this.personaService
        .eliminarPersona(this.idPersona)
        .subscribe({ next: () => this.router.navigate(['']) });
    }
  }
}
