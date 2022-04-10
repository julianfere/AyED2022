import tp02.ejercicio1.*;
public class PritnRecursivo {

	public static void printRecursivo(ListaDeEnterosEnlazada lista) {
		if ( lista.esVacia() || lista.fin()) {
			return;
		}
		Integer valor = lista.proximo();
		printRecursivo(lista);
		System.out.println(valor);
	}
	
	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		
		for (int i = 0; i < 5; i++) {
			lista.agregarFinal(i);
		}
		
		lista.comenzar();
		
		printRecursivo(lista);
	}
}
