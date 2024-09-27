import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from './persona.model';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  private urlBase = 'http://localhost:8080/PersonaBackendJava/webservice/personas';

  constructor(private clienteHttp: HttpClient) {}

  obtenerPersonasLista(): Observable<Persona[]> {
    return this.clienteHttp.get<Persona[]>(this.urlBase);
  }

  agregarPersona(persona: Persona): Observable<Object> {
    return this.clienteHttp.post(this.urlBase, persona);
  }

  encontrarPersona(id: number) {
    return this.clienteHttp.get<Persona>(`${this.urlBase}/${id}`);
  }

  modificarPersona(id: number, persona: Persona): Observable<Object> {
    return this.clienteHttp.put(`${this.urlBase}/${id}`, persona);
  }

  eliminarPersona(id: number): Observable<Object> {
    return this.clienteHttp.delete(`${this.urlBase}/${id}`);
  }
}
