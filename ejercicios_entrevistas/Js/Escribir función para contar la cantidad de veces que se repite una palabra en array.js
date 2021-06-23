/*Escribir función para contar la cantidad de veces que se repite una palabra en array*/

const repeated = (str) => {
	const lowered = str.toLowerCase();
	const splitted = lowered.split(' ');
	const reduced = splitted.reduce((acc, el) => {
		if (acc[el]) {
			acc[el]++;
		} else {
			acc[el] = 1;
		}
		return acc;
	}, {});
	return Object.entries(reduced).reduce((acc, el) =>
		acc[1] > el[1] ? acc : el,
	);
};

const e = repeated('this is a tu puta madre puta puta');
console.log('-------------------------------------');
console.log(e);