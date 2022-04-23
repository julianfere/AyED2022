package Practica3;

import TiposDeDatos.*;

public class ContadorArbolTest {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<>(1);
		
		ArbolBinario<Integer> hijoDer = new ArbolBinario<>(3);
		ArbolBinario<Integer> hijoIzq = new ArbolBinario<>(2);
		
		hijoIzq.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		hijoIzq.agregarHijoDerecho(new ArbolBinario<Integer>(5));

		arbol.agregarHijoDerecho(hijoDer);
		arbol.agregarHijoIzquierdo(hijoIzq);
		
		ContadorArbol contador = new ContadorArbol(arbol);
		
		ListaEnlazadaGenerica<Integer> lista = contador.numerosPares();
		
		lista.comenzar();
		
		for (int i = 0; i < lista.tamanio(); i++) {
			System.out.print(lista.proximo() + " ");
		}
	}

}
