class Persona {
  static contadorPersonas = 0;

  static get MAX_OBJ() {
    return 5;
  }

  constructor(nombre, apellido) {
    if (Persona.contadorPersonas < Persona.MAX_OBJ) {
      this._nombre = nombre;
      this._apellido = apellido;
      this.idPersona = ++Persona.contadorPersonas;
    } else {
      console.log("Error, límite alcanzado");
    }
  }

  get nombre() {
    return this._nombre;
  }

  set nombre(nombre) {
    this._nombre = nombre;
  }

  get apellido() {
    return this._apellido;
  }

  set apellido(apellido) {
    this._apellido = apellido;
  }

  nombreCompleto() {
    return this.idPersona + " " + this._nombre + " " + this._apellido;
  }

  //Sobreescribiendo el metodo de la clase padre (Object)
  toString() {
    //Se aplica polimorfismo (multiples formas en tiempo de ejecución)
    // El método que se ejecuta depende si es una referencia de tipo padre o de tipo hijo
    return this.nombreCompleto();
  }

  static saludar() {
    console.log("Saludos estáticos");
  }

  static saludar2(persona) {
    console.log("Saludos " + persona.nombreCompleto());
  }
}

class Empleado extends Persona {
  constructor(nombre, apellido, departamento) {
    super(nombre, apellido); //Llamar al constructor de la clase padre
    this._departamento = departamento;
  }

  get departamento() {
    return this._departamento;
  }
  set departamento(departamento) {
    this._departamento = departamento;
  }

  //Sobreescritura
  nombreCompleto() {
    return super.nombreCompleto() + ", " + this._departamento;
  }
}

let persona1 = new Persona("Juan", "Pérez");
console.log(persona1.toString());

let empleado1 = new Empleado("Maria", "Jimenez", "Sistemas");
console.log(empleado1.toString());

console.log(Persona.contadorPersonas);

let persona2 = new Persona("Karla", "Lara");
console.log(persona2.toString());

console.log(Persona.contadorPersonas);

console.log(Persona.MAX_OBJ);
Persona.MAX_OBJ = 10;
console.log(Persona.MAX_OBJ);

let persona3 = new Persona("Mariano", "Lara");
let persona4 = new Persona("Pancho", "Lara");
let persona5 = new Persona("Suli", "Lara");
console.log(persona5.toString());

