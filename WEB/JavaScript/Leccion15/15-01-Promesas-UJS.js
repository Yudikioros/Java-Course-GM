let miPromesa = new Promise((resolved, rejected) => {
  let expresion = true;
  if (expresion) {
    resolved("Resuelto");
  } else {
    rejected("Error");
  }
});

// miPromesa.then(
//   (valor) => console.log(valor),
//   (error) => console.log(error)
// );

// miPromesa
//   .then((valor) => console.log(valor))
//   .catch((error) => console.log(error));

let promesa = new Promise((resolved) => {
  //   console.log("Inicio promesa");
  setTimeout(() => resolved("Saludos desde promesa"), 300);
  //   console.log("Fin promesa");
});

// promesa.then((valor) => console.log(valor));

//Async: indica que una función regresa una promesa

async function miFuncionConPromesa() {
  return "Saludos con promesa y async";
}
// miFuncionConPromesa().then(valor=>console.log(valor));

//Async/Await (deben ir juntos)

async function funcionConPromesaYAwait() {
  let miPromesa = new Promise((resolver) => {
    resolver("Promesa con await");
  });
  console.log(await miPromesa);
}

// funcionConPromesaYAwait();

//Promesas, await, async, setTimeout

async function funcionConPromesaAwaitYTimeout() {
  console.log("Inicio");
  let miPromesa = new Promise((resolver) => {
    setTimeout(() => resolver("Promesa con await y timeout"), 3000);
  });
  console.log(await miPromesa);
  console.log("Fin");
}

funcionConPromesaAwaitYTimeout();
