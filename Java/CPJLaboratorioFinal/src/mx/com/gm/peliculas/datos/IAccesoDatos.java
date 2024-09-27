package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {

    public boolean existe(String nombreRecurso) throws AccesoDatosEx;

    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    public void crear(String nombreRecurso) throws AccesoDatosEx;

    public void borrar(String nombreRecurso) throws AccesoDatosEx;
}
