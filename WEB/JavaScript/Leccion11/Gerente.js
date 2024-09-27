class Gerente extends Empleado {
  constructor(nombre, sueldo, departamento) {
    super(nombre, sueldo);
    this.departamento = departamento;
  }
  obtenerDetalles() {
    return `Gerente: ${super.obtenerDetalles()}, departamento: ${
      this.departamento
    }`;
  }
}
