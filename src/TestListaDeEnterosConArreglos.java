
import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {
	public static void main(String[] args) {
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		for(int i = 0; i < args.length; i++) {
			Integer numero = Integer.parseInt(args[i]);
			lista.agregarFinal(numero);
		}
		lista.comenzar();
		
		while (!lista.esVacia() && !lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
