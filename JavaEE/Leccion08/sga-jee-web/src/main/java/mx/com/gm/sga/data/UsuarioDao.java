package mx.com.gm.sga.data;

import mx.com.gm.sga.domain.Usuario;

import java.util.List;

public interface UsuarioDao {
    public List<Usuario> getUsuarios();
    public Usuario getUsuarioById(Usuario usuario);
    public void add(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
}
