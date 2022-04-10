import tp02.ejercicio1.*;


public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		ListaDeEnterosEnlazada lista = calculadora.CalcularSucesion(6);
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
	}

}
