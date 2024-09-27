import { Egreso } from './egreso.model';

export class EgresoService {
  egresos: Egreso[] = [
    new Egreso('Egreso 1', 100),
    new Egreso('Egreso 2', 200),
  ];
  eliminar(egreso: Egreso) {
    const index: number = this.egresos.indexOf(egreso);
    this.egresos.splice(index, 1);
  }
}
