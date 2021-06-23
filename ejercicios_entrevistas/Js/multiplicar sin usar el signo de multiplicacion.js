/* multiplicar numeros sin usar el signo de multiplicacion */

const multiply = (a, b) => {
	let resultado = 0;
	const positivo = Math.abs(b) == b; //aca preguntamos si b es positivo o negativo
	for (i = 0; i < Math.abs(b); i++) {
		resultado = positivo ? resultado + a : resultado - a; //aca preguntamos si la suma es positiva se suma, si es negativa se resta
	}

	return resultado;
};
const a = multiply(-4, -5);
console.log(a);

/*encontrar el numero mayor en un arregle pero iterando este mismo una sola vez*/
console.log('-------------------------------------');
const biggest = (arr) => arr.reduce((acc, el) => (acc > el ? acc : el));
const b = biggest([10, 22, 50, 2000, -100000]);
console.log(b);