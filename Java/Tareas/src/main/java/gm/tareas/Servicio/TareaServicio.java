package gm.tareas.Servicio;

import gm.tareas.modelo.Tarea;
import gm.tareas.repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio implements ITareaServicio{

    @Autowired
    private TareaRepositorio repositorio;

    @Override
    public List<Tarea> listarTareas() {
        return repositorio.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        repositorio.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        repositorio.delete(tarea);
    }
}
