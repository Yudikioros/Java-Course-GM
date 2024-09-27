import { Ingreso } from "./ingreso.model";

export class IngresoService{
  ingresos: Ingreso[] = [
    new Ingreso("Ingreso 1", 10000),
    new Ingreso("Ingreso 2", 200)
  ];

  eliminar(ingreso: Ingreso) {
    const index: number = this.ingresos.indexOf(ingreso);
    this.ingresos.splice(index, 1);
  }
}
