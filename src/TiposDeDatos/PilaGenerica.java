package TiposDeDatos;

public class PilaGenerica<T> {
	private ListaGenerica<T> pila;
	
	public PilaGenerica() {
		this.pila = new ListaEnlazadaGenerica<>();
	}
	
	public void apilar(T element) {
		this.pila.agregarInicio(element);
	}
	
	public T desapilar() {
		if (this.esVacia()) {
			return null;
		}
		
		T elem = this.tope();
		this.pila.eliminarEn(1);
		return elem;
	}
	
	public T tope() {
		return this.pila.elemento(1);
	}
	
	public boolean esVacia() {
		return this.pila.esVacia();
	}
}
