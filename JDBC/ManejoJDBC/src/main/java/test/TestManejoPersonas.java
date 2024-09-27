package test;

import datos.PersonaJDBC;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaJDBC personaJDBC = new PersonaJDBC();
//        for (Persona persona : personas) {
//            System.out.println(persona);
//        }
        //Insersión
        Persona persona = new Persona("Carlos", "Esparza", "cesparza@mail.com", "5522336699");
//        personaJDBC.insertar(persona);

        // Actualizar
        Persona personaModificar = new Persona(3,"Juan Carlos", "Esparza", "jcesparza@mail.com", "5522336699");
        personaJDBC.actualizar(personaModificar);

        //Eliminar registros
        Persona personaEliminar = new Persona(3,"Juan Carlos", "Esparza", "jcesparza@mail.com", "5522336699");
        personaJDBC.eliminar(personaEliminar);

        //Recoger registros
        List<Persona> personas = personaJDBC.seleccionar();

        //Lambda (Mostrar)
        personas.forEach(System.out::println);
    }
}
