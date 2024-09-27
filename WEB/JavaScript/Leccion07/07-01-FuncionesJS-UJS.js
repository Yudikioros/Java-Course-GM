function miFuncion(a, b) {
  console.log(arguments.length);
  return a + b; // Si no se agrega return JS lo hace automaticámente
}

let resultado = miFuncion(2, 3);
console.log(resultado);

//Hoisting: la definición de la función se mueve siempre al inicio del programa

//Declaración de una función de tipo expresión
let sumar = function (a = 4, b = 5) {
  console.log(arguments[0]);
  console.log(arguments[1]);
  return a + b;
};

resultado = sumar(1, 2);
console.log(resultado);

//Self-invoking
(function (a, b) {
  console.log("Ejecutando función" + ": " + (a + b));
})(3, 4);

console.log(typeof miFuncion);

var miFuncionTexto = miFuncion.toString();
console.log(miFuncionTexto);

//Arrow funtions
const sumarFuncionTipoFlecha = (a, b) => a + b;
resultado = sumarFuncionTipoFlecha(3, 5);
console.log(resultado);

let resultado2 = sumarTodo(4, 5, 6, 7, 8);
console.log(resultado2);

function sumarTodo() {
  let suma = 0;
  for (let i = 0; i < arguments.length; i++) {
    suma += arguments[i];
  }
  return suma;
}

//Tipos primitivos
let x = 10;

function cambiarValor(a){
  a = 20;
}

//Paso por valor
cambiarValor(x);//10
console.log(x);

const persona = {
  nombre: 'Juan',
  apellido: 'Perez'
}

function cambiarValorObjeto(p1){
  p1.nombre = 'Carlos';
  p1.apellido = 'Lara';
}

//Paso por referencia
cambiarValorObjeto(persona);
console.log(persona);


//? Los valores hexadecimales comienzan con 0X