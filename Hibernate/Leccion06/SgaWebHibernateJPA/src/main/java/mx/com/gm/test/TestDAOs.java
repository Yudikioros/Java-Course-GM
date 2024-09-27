package mx.com.gm.test;

import mx.com.gm.dao.*;
import mx.com.gm.domain.Contacto;

import java.util.List;

public class TestDAOs {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("Alumnos");
        imprimir(alumnoDAO.listar());

        System.out.println("Domicilios");
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        imprimir(domicilioDAO.listar());

        System.out.println("Contactos");
        ContactoDAO contactoDAO = new ContactoDAO();
        imprimir(contactoDAO.listar());

        System.out.println("Cursos");
        CursoDAO cursoDAO = new CursoDAO();
        imprimir(cursoDAO.listar());

        System.out.println("Asignaciones");
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        imprimir(asignacionDAO.listar());

    }
    private static void imprimir(List lista){
        lista.forEach(System.out::println);
    }
}
