let x = 10;

let persona = {
  nombre: "Juan",
  apellido: "Pérez",
  email: "jperez@mail.com",
  edad: 28,
  idioma: "es",
  get lang() {
    return this.idioma.toUpperCase();
  },
  set lang(lang) {
    this.idioma = lang.toUpperCase();
  },
  get nombreCompleto() {
    return this.nombre + " " + this.apellido;
  },
};

console.log(persona);
// console.log(persona.nombreCompleto());

let persona2 = new Object();
persona2.nombre = "Carlos";
persona2.direccion = "Saturno 14";
persona2.telefono = "1234567890";

console.log(persona2.nombre);

console.log(persona["apellido"]);

//For in
for (nombrePropiedad in persona) {
  console.log(nombrePropiedad);
  console.log(persona[nombrePropiedad]);
}

persona.tel = "1234567890";
persona.tel = "11";
console.log(persona);

delete persona.tel;
console.log(persona);

//Concatenar cada valor de cada propiedad
console.log(persona.nombre + ", " + persona.apellido);

//For in
for (nombrePropiedad in persona) {
  console.log(persona[nombrePropiedad]);
}

let personaArray = Object.values(persona);
console.log(personaArray);

let personaString = JSON.stringify(persona);
console.log(personaString);

//Get y set
console.log(persona.nombreCompleto);
console.log(persona.lang);

persona.lang = "en";
console.log(persona.lang);
console.log(persona.idioma);

//Función constructor de tipo persona
function Persona(nombre, apellido, email) {
  this.nombre = nombre;
  this.apellido = apellido;
  this.email = email;
  this.nombreCompleto = function () {
    return this.nombre + " " + this.apellido;
  };
}

//Añadir atributos sin modificar el constructor
Persona.prototype.tel = "44332211";

let padre = new Persona("Juan", "Pérez", "jperez@mail.com");
console.log(padre.nombreCompleto());
padre.tel = '123';
console.log(padre.tel);

let madre = new Persona("Laura", "Quintero", "lquintero@mail.com");
console.log(madre.nombreCompleto());

padre.nombre = "Carlos";

console.log(padre);
console.log(madre);

let miObjeto = new Object();
let miObjeto2 = {};

let miCadena1 = new String("Hola");
let miCadena2 = "Hola";

let miNumero1 = new Number(1);
let miNumero2 = 1;

let MiBoolean1 = new Boolean(false);
let MiBoolean2 = false;

let MiArray1 = new Array();
let MiArray2 = [];

let miFuncion1 = new Function();
let miFuncion2 = function () {};

//Call
let persona3 = {
  nombre: 'Juan',
  apellido: 'Perez',
  nombreCompleto: function(titulo, tel){
    return titulo + ': ' + this.nombre + ' ' + this.apellido + ', ' + tel;
  }
  // nombreCompleto: function(){
  //   return this.nombre + ' ' + this.apellido;
  // }
}

let persona4 = {
  nombre: 'Laura',
  apellido: 'Lara'
}

//Uso de call para usar el metodo persona1.nombreCompleto 
//con los datos de persona2
console.log(persona3.nombreCompleto('Ing', '5544332211'));
console.log(persona3.nombreCompleto.call(persona4, 'Ing', '5544332211'));

//Apply mismo funcionamiento que call pero utilizando un arreglo
console.log(persona3.nombreCompleto('Lic', '1122334455'));

let argumentos = ['Ing','5544332211'];
console.log(persona3.nombreCompleto.apply(persona4, argumentos));