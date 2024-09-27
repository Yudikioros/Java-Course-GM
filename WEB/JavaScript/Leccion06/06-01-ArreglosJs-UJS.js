// let autos = new Array('BMX', 'MB', 'Volvo');
const autos = ["BMW", "Mercedes Benz", "Volvo"];
console.log(autos);

console.log(autos[0]);
console.log(autos[2]);

for (let i = 0; i < autos.length; i++) {
    console.log(i + " : " + autos[i]);
}

autos[1] = 'MercedezBenz';
console.log(autos)

autos.push("Audi");
console.log(autos);

autos[autos.length] = "Cadillac";
console.log(autos)

autos[5] = "Porshe";
console.log(autos)

console.log(typeof autos);
console.log(Array.isArray(autos));
console.log(autos instanceof Array);
