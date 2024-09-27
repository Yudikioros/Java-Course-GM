package datos;

import domain.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.close;

public class UsuarioDaoJDBC implements UsuarioDao{
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";

    public UsuarioDaoJDBC() {
    }

    public UsuarioDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<UsuarioDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioDTO usuarioDTO = null;
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId_usuario(rs.getInt("id_usuario"));
                usuarioDTO.setUsuario(rs.getString("usuario"));
                usuarioDTO.setPassword(rs.getString("password"));
                usuarioDTOS.add(usuarioDTO);
            }
        } finally {
            try {
                close(rs);
                close(ps);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return usuarioDTOS;
    }

    @Override
    public int insert(UsuarioDTO usuarioDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, usuarioDTO.getUsuario());
            ps.setString(2, usuarioDTO.getPassword());
            registros = ps.executeUpdate();
        } finally {
            try {
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return registros;
    }

    @Override
    public int update(UsuarioDTO usuarioDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, usuarioDTO.getUsuario());
            ps.setString(2, usuarioDTO.getPassword());
            ps.setInt(3, usuarioDTO.getId_usuario());
            registros = ps.executeUpdate();
        } finally {
            try {
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return registros;
    }

    @Override
    public int delete(UsuarioDTO usuarioDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, usuarioDTO.getId_usuario());
            registros = ps.executeUpdate();
        } finally {
            try {
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return registros;
    }
}
