package test;

import datos.Conexion;
import datos.PersonaJDBC;
import domain.Persona;

import java.sql.*;

public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);

            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Karla Ivonne");
            cambioPersona.setApellido("Gómez");
            cambioPersona.setEmail("kgomez@mail.com");
            cambioPersona.setTelefono("5544778899");
            personaJDBC.actualizar(cambioPersona);

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            //nuevaPersona.setApellido("Ramírezllllllllllllllllllllllllllllllllllllllllllll");
            nuevaPersona.setApellido("Ramírez");
            personaJDBC.insertar(nuevaPersona);

            conexion.commit();
            System.out.println("Commit");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
