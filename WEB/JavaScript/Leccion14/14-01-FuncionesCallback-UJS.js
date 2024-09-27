function miFuncion1() {
  console.log("Función1");
}

function miFuncion2() {
  console.log("Función2");
}

miFuncion1();
miFuncion2();

//Funciones Callback

let imp = function imprimir(mensaje) {
  console.log(mensaje);
};

function sumar(op1, op2, functionCallback) {
  let resultado = op1 + op2;
  functionCallback(`Resultado: ${resultado}`);
}

sumar(5, 3, imp);

//Llamadas asíncronas con uso setTimeout

function miFuncionCallback() {
  console.log("Saludo asíncrono");
}

setTimeout(miFuncionCallback, 3000); //Después de 3 seg
setTimeout(function () {
  console.log("Saludo asíncrono 2");
}, 4000);

setTimeout(() => console.log("Saludo asíncrono 3"), 5000);

//Intervalos asíncronos
let reloj = () => {
  let fecha = new Date();
  console.log(
    `${fecha.getHours()}:${fecha.getMinutes()}:${fecha.getSeconds()}`
  );
};

// setInterval(reloj, 1000); //1 Segundo
