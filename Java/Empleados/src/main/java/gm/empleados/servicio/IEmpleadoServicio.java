package gm.empleados.servicio;

import gm.empleados.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();
    public Empleado buscarEmpleadoPorId(Integer id);
    public void guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);
}
