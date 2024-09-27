package gm.rh.servicio;

import gm.rh.modelo.Empleado;
import gm.rh.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private EmpleadoRepositorio repositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return repositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        repositorio.delete(empleado);
    }
}
