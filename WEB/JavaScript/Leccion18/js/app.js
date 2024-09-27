console.log("Aplicación calculadora");

function sumar() {
  const forma = document.forms["forma"];
  let operandoA = forma["operandoA"];
  let operandoB = forma["operandoB"];
  let resultado = parseInt(operandoA.value) + parseInt(operandoB.value);
  resultado = isNaN(resultado) ? "La operación no es númerica" : resultado;
  document.getElementById("resultado").innerHTML = `Resultado: ${resultado}`;
  console.log(`Resultado: ${resultado}`);
}
