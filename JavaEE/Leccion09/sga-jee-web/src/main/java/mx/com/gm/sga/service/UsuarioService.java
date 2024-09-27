package mx.com.gm.sga.service;

import jakarta.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

import java.util.List;

@Local
public interface UsuarioService {
    public List<Usuario> getUsuarios();

    public Usuario getUsuarioById(Usuario usuario);

    public void addUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);
}
