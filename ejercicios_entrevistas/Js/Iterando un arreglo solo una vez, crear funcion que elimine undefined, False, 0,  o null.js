/* Iterando un arreglo solo una vez, crear función que elimine: undefined, False, 0,  ó null*/

const clean = (arr) =>
	arr.reduce((acc, el) => {
		if (el) {
			acc.push(el);
		}
		return acc;
	}, []);

const c = clean([1, undefined, null, 0, 2, 3]);
console.log('-------------------------------------');
console.log(c);
/*Escribir función que aplana los arreglos en un nivel  (separar arreglos en niveles)*/

const arr = [[1, 2], [[3, 4]], [1, []]];
const flatten = (arr) => arr.reduce((acc, el) => acc.concat(el), []);
const d = flatten(arr);
console.log('-------------------------------------');
console.log(d);