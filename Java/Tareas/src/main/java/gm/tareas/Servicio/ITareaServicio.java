package gm.tareas.Servicio;

import gm.tareas.modelo.Tarea;

import java.util.List;

public interface ITareaServicio {
    public List<Tarea> listarTareas();
    public Tarea buscarTareaPorId(Integer id);
    public void guardarTarea(Tarea tarea);
    public void eliminarTarea(Tarea tarea);
}
