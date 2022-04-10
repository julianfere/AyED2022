package TiposDeDatos;

public class ColaGenerica<T> {
	private ListaGenerica<T> cola;

	public ColaGenerica() {
		this.cola = new ListaEnlazadaGenerica<T>();
	}

	public void encolar(T elemet) {
		this.cola.agregarFinal(elemet);
	}
	
	public T desencolar() {
		T elem = tope();
		this.cola.eliminarEn(1);
		
		return elem;
	}
	
	public T tope() {
		return cola.elemento(1);
	}
	
	public boolean esVacia() {
		return this.cola.esVacia();
	}
}

