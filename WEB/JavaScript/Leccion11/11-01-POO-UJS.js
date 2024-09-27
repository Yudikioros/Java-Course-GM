class Empleado {
  constructor(nombre, sueldo) {
    this.nombre = nombre;
    this.sueldo = sueldo;
  }
  obtenerDetalles() {
    return `Empleado: nombre ${this.nombre}, sueldo: ${this.sueldo}`;
  }
}

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

//Polimorfismo = Múltiples formas
function determinarTipo(tipo) {
  console.log(tipo.obtenerDetalles());
  if (tipo instanceof Gerente) {
    console.log("Tipo Gerente");
  } else if (tipo instanceof Empleado) {
    console.log("Tipo Empleado");
  } else if (tipo instanceof Object) {
    console.log("Tipo Object");
  }
}

let empleado1 = new Empleado("Carlos", 8000);
let gerente1 = new Gerente("Carlos", 5000, "Sistemas");

determinarTipo(empleado1);
determinarTipo(gerente1);
