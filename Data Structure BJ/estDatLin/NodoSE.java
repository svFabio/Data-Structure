package estDatLin;
/**
 * Clase que representa un nodo de una lista simplemente enlazada.
 */
public class NodoSE<T> {
    private T dato;          // Dato almacenado en el nodo
    private NodoSE<T> suc;   // Referencia al siguiente nodo

    // Constructor sin par�metros que inicializa el nodo vac�o
    public NodoSE() {
        dato = null;          // Dato nulo
        suc = null;           // Siguiente nodo nulo
    }

    // Constructor que inicializa el nodo con un valor dado
    public NodoSE(T valor) {
        dato = valor;         // Asignar el valor al dato
        suc = new NodoSE();   // Crear un nuevo nodo vac�o como siguiente nodo
    }

    // M�todo para obtener el dato del nodo
    public T getDato() {
        return dato;
    }

    // M�todo para obtener el siguiente nodo
    public NodoSE<T> getSuc() {
        return suc;
    }

    // M�todo para establecer el dato del nodo
    public void setDato(T valor) {
        dato = valor;
    }

    // M�todo para establecer el siguiente nodo
    public void setSuc(NodoSE<T> otro) {
        suc = otro;
    }

    // M�todo que verifica si el nodo est� vac�o (sin dato)
    public boolean vacio() {
        return dato == null; // Devuelve true si el dato es nulo
    }
}
