package test;

import datos.UsuarioJDBC;
import domain.Usuario;

import java.util.List;

public class ManejoUsuarios {
    public static void main(String[] args) {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();

        //Insertar
        Usuario usuario = new Usuario("carlos.juarez", "123");
//        usuarioJDBC.insertar(usuario);

        //Modificación
        Usuario usuario2 = new Usuario(3, "carlos.juarez", "456");
        usuarioJDBC.actualizar(usuario2);

        // Eliminación
        Usuario usuario3 = new Usuario(4);
        usuarioJDBC.eliminar(usuario3);

        //Lista de usuarios
        List<Usuario> usuarios = usuarioJDBC.seleccionar();
        usuarios.forEach(System.out::println);

    }
}
