package mx.com.gm.sga.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import mx.com.gm.sga.data.UsuarioDao;
import mx.com.gm.sga.domain.Usuario;

import java.util.List;

@Stateless
public class UsuarioServieImpl implements UsuarioService, UsuarioServiceRemote{

    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @Override
    public Usuario getUsuarioById(Usuario usuario) {
        return usuarioDao.getUsuarioById(usuario);
    }

    @Override
    public void addUsuario(Usuario usuario) {
        usuarioDao.add(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
