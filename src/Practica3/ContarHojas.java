package Practica3;

import TiposDeDatos.ArbolBinario;

public class ContarHojas {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<>(1);
		
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2);
		
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<Integer>(5));

		arbol.agregarHijoDerecho(hijoDer);
		arbol.agregarHijoIzquierdo(hijoIzq);
		//       1
		//      / \
		//     2   3 
		//    / \
		//   4   5   
		System.out.print(arbol.contarHojas());
	}
}
