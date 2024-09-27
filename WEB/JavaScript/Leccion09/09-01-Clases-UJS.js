//Es necesario definir una clase antes de llamarla (No se aplica hoisting)
class Persona {
  static contadorObjetosPersona = 0;// Atributo de nuestra clase
  email = 'Valor por defecto';// Atributo de nuestros objetos

  constructor(nombre, apellido) {
    this._nombre = nombre;
    this._apellido = apellido;
    Persona.contadorObjetosPersona++;
    console.log("Se incrementa " + Persona.contadorObjetosPersona);
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
    return this._nombre + " " + this._apellido;
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

let persona1 = new Persona("Juan", "Perez");
persona1.nombre = "Cuco"; //set nombre('Cuco')
console.log(persona1.nombre); //get nombre()1 

let empleado1 = new Empleado("Maria", "Jimenez", "Sistemas");
console.log(empleado1.toString());

console.log(empleado1.nombreCompleto());

// persona1.saludar(); No es posible llamar el método estático desde una clase
Persona.saludar();
Persona.saludar2(persona1);
Empleado.saludar2(empleado1);

console.log(Persona.contadorObjetosPersona);
console.log(Empleado.contadorObjetosPersona);

console.log(persona1.email);
console.log(empleado1.email);
console.log(Persona.email);
console.log(Empleado.email);