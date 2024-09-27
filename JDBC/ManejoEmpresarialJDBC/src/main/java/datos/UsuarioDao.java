package datos;

import domain.UsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
    public List<UsuarioDTO> select() throws SQLException;
    public int insert(UsuarioDTO Usuario) throws SQLException;
    public int update(UsuarioDTO Usuario) throws SQLException;
    public int delete(UsuarioDTO Usuario) throws SQLException;
}
