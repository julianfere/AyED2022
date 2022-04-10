package Practica2;
import tp02.ejercicio1.*;
public class Calculadora {
	
	public ListaDeEnterosEnlazada CalcularSucesion(int numero) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		lista.agregarFinal(numero);
		this.CalcularSucesion(lista, numero);
		
		return lista;
	}
	
	private void CalcularSucesion(ListaDeEnterosEnlazada lista, Integer numero) {
		if (numero == 1) {
			return;
		}
		
		if (numero % 2 == 0) {
			numero = numero / 2;
		} else {
			numero = 3*numero+1;
		}
		
		lista.agregarFinal(numero);
		this.CalcularSucesion(lista, numero);
	}

}
