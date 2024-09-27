package test;

import datos.Conexion;
import datos.UsuarioJDBC;
import domain.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManejoUsuarios {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            UsuarioJDBC usuarioJDBC = new UsuarioJDBC(conexion);


            //Insertar
            Usuario usuario = new Usuario("karla.lara", "852");
            usuarioJDBC.insertar(usuario);

            //Modificación
            Usuario usuario2 = new Usuario(3, "carlos.ramirez", "456");
            usuarioJDBC.actualizar(usuario2);

            // Eliminación
//            Usuario usuario3 = new Usuario(4);
//            usuarioJDBC.eliminar(usuario3);

            //Lista de usuarios
            List<Usuario> usuarios = usuarioJDBC.seleccionar();
            usuarios.forEach(System.out::println);

            conexion.commit();
            System.out.println("Commit");
        }catch (SQLException e) {
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
