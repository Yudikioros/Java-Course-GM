package gm.contactos.servicio;

import gm.contactos.modelo.Contacto;

import java.util.List;

public interface IContactoServicio {
    public List<Contacto> listarContactos();
    public Contacto buscarContactoPorId(Integer id);
    public void guardarContacto(Contacto contacto);
    public void eliminarContacto(Contacto contacto);
}
