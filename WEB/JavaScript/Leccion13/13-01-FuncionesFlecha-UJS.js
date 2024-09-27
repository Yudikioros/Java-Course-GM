let miFuncion = function () {
  console.log("Saludos desde miFuncion");
};
miFuncion();

//No aplica Hoisting al definir una función en una variable
// const miFuncionFlecha = () =>{
//     console.log("Saludos desde mi función flecha");
// }

// const miFuncionFlecha = () => console.log("Saludos desde mi función flecha");

// const sauludar = () =>{
//     return 'Saludos desde función flecha';
// }

const saludar = () => "Saludos desde función flecha";

const regresaObjeto = () => ({ nombre: "Juan" });
console.log(regresaObjeto());

// const funcionConParametros = (mensaje) => console.log(mensaje);
//Si solo es un parametro no son necesarios los parentesis
const funcionConParametros = mensaje => console.log(mensaje);
funcionConParametros("Hola");

const funcionVariosParametros = (a,b) => a+b;
console.log(funcionVariosParametros(5,6));
