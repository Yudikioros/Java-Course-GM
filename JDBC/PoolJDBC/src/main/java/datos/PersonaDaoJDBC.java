package datos;

import domain.PersonaDTO;

import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaDaoJDBC implements PersonaDao {
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public PersonaDaoJDBC() {
    }

    public PersonaDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;
        List<PersonaDTO> personaDTOS = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                personaDTO = new PersonaDTO();
                personaDTO.setIdPersona(rs.getInt("id_persona"));
                personaDTO.setNombre(rs.getString("nombre"));
                personaDTO.setApellido(rs.getString("apellido"));
                personaDTO.setEmail(rs.getString("email"));
                personaDTO.setTelefono(rs.getString("telefono"));
                personaDTOS.add(personaDTO);
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
        return personaDTOS;
    }

    @Override
    public int insert(PersonaDTO personaDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, personaDTO.getNombre());
            ps.setString(2, personaDTO.getApellido());
            ps.setString(3, personaDTO.getEmail());
            ps.setString(4, personaDTO.getTelefono());
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
    public int update(PersonaDTO personaDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, personaDTO.getNombre());
            ps.setString(2, personaDTO.getApellido());
            ps.setString(3, personaDTO.getEmail());
            ps.setString(4, personaDTO.getTelefono());
            ps.setInt(5, personaDTO.getIdPersona());
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
    public int delete(PersonaDTO personaDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, personaDTO.getIdPersona());
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
