// "use strict";
// try {
//   let x = 10;
//   //   miFuncion();
//   throw "Mi error";
// } catch (error) {
//   console.log(error);
// } finally {
//   console.log("Termina la revisión");
// }
// console.log("Continuamos...");
let resultado = "a";
try {
  if (isNaN(resultado)) throw "No es un número";
  else if (resultado == "") throw "Cadena vacía";
  else if(resultado >= 0) throw 'Valor positivo'
  else if(resultado < 0) throw 'Valor negativo'
} catch (error) {
  console.log(error);
  // console.log(error.name);
  // console.log(error.message);
}finally{
    console.log("Bloque final");
}
