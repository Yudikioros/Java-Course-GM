package test;

import datos.Conexion;
import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;

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
            UsuarioDao usuarioDao = new UsuarioDaoJDBC(conexion);

            //Lista de usuarioDTOS
            List<UsuarioDTO> usuarios = usuarioDao.select();
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
