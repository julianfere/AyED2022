package TiposDeDatos;

public class ContadorArbol {
	
	private ArbolBinario<Integer> arbol;

	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.setArbol(arbol);
	}
	

	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private void numerosPares(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista) {
		if (arbol == null)
			return;
	
		
		numerosPares(arbol.getHijoIzquierdo(), lista);

		if (arbol.getDato() % 2 == 0)
			lista.agregarInicio(arbol.getDato());
		
		numerosPares(arbol.getHijoDerecho(), lista);
	}
	
	public ListaEnlazadaGenerica<Integer> numerosPares() {
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		
		numerosPares(this.getArbol(), lista);

		return lista;
	}
}
