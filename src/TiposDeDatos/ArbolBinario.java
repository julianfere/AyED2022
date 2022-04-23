package TiposDeDatos;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	
    public void printPreorden() {
        System.out.println(this.getDato());
 
        if(this.tieneHijoIzquierdo())
            this.getHijoIzquierdo().printPreorden();
 
        if(this.tieneHijoDerecho())
            this.getHijoDerecho().printPreorden();
    }

    public void printPostorden() {
        if(this.tieneHijoIzquierdo())
            this.getHijoIzquierdo().printPreorden();

        if(this.tieneHijoDerecho())
            this.getHijoDerecho().printPreorden();
   
        System.out.println(this.getDato());
    }

    public void printInorden(){
        if(this.tieneHijoIzquierdo())
            this.getHijoIzquierdo().printInorden();
  
        System.out.println(this.getDato());       
 
        if(this.tieneHijoDerecho())
            this.getHijoDerecho().printInorden(); 
    }
    
    public void printPorNiveles() {
        ColaGenerica <ArbolBinario<T>> cola = new ColaGenerica<>();
        
        ArbolBinario <T> arbol;
        
        cola.encolar(this);
        cola.encolar(null);
        
        while(!cola.esVacia()){
            arbol = cola.desencolar();
            
            if(arbol != null){
                System.out.println(arbol.getDato());
                
                if(arbol.tieneHijoIzquierdo())
                    cola.encolar(arbol.getHijoIzquierdo());
                
                if(arbol.tieneHijoDerecho())
                    cola.encolar(arbol.getHijoDerecho());
            
            } else if (!cola.esVacia()){
                 System.out.println();
                 cola.encolar(null);
            }
        }            	
    }
	
	public int contarHojas(ArbolBinario<T> arbol) {
		if (arbol != null && arbol.esHoja())
			return 1;
		
		int hojasDer = 0; 
		int hojasIzq = 0;
	
		if (arbol.tieneHijoDerecho())
			hojasDer = contarHojas(arbol.getHijoDerecho());
	
	    if (arbol.tieneHijoIzquierdo())
	    	hojasIzq = contarHojas(arbol.getHijoIzquierdo());	
		
		return hojasDer + hojasIzq;
	}
	
	public int contarHojas() {
		if (this.esVacio())
			return 0;

		return contarHojas(this);
	}
	
    public int altura(){ 
        if (this.esVacio())
            return -1;
        
	    int altIzq=-1, 
	        altDer=-1;
	 
	    if(this.tieneHijoIzquierdo())
	      altIzq = this.getHijoIzquierdo().altura();
	        
	     if(this.tieneHijoDerecho())
	       altDer = this.getHijoDerecho().altura();
	            
	    return Math.max(altIzq, altDer) + 1;
    }

    public ArbolBinario<T> espejo() {
    	if (this.esVacio())
    		return new ArbolBinario<>();
    	
    	 ArbolBinario<T> nuevoArbol = new  ArbolBinario<>(this.getDato());
    	 
    	 if (this.tieneHijoIzquierdo())
    		 nuevoArbol.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
    	 
    	 if (this.tieneHijoDerecho())
    		 nuevoArbol.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
    	 
    	 return nuevoArbol;
	}

    
    public boolean esLleno() {
        boolean lleno = true;
        int nivel = 0;
        int nodo = 0;
        
        ArbolBinario<T> arbol;
        ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
        
        cola.encolar(this);
        cola.encolar(null);
        
        while(!cola.esVacia() && (lleno)) {
            arbol = cola.desencolar();
            if(arbol != null) {
                if(arbol.tieneHijoIzquierdo()) {
                    nodo++;
                    cola.encolar(arbol.getHijoIzquierdo());
                }
                if(arbol.tieneHijoDerecho()) {
                    nodo++;
                    cola.encolar(arbol.getHijoDerecho());
                }
            }
            else {
                if (!cola.esVacia()) {
                    nivel++;
                    if(nodo == Math.pow(2, nivel)) {
                        cola.encolar(null);
                        nodo = 0;
                    }else 
                        lleno = false;
                }
            }			
        }		
        return lleno;
    }

    public ListaGenerica<T> frontera() {
	ListaGenerica<T> l = new ListaEnlazadaGenerica<>();
	return l;
    }

	public void entreNiveles(int n, int m){
		
	}

	

}
