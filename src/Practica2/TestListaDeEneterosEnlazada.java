package Practica2;

import tp02.ejercicio1.*;

public class TestListaDeEneterosEnlazada {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		for(int i = 0; i < args.length; i++) {
			Integer numero = Integer.parseInt(args[i]);
			lista.agregarFinal(numero);
		}
		
		lista.comenzar();
		
		while(!lista.esVacia() && !lista.fin()) {
			System.out.println(lista.proximo());
		}
	}

}
