package estDatLin;
/**
 * Clase que representa un nodo de una lista simplemente enlazada.
 */
public class NodoSE<T> {
    private T dato;          // Dato almacenado en el nodo
    private NodoSE<T> suc;   // Referencia al siguiente nodo

    // Constructor sin parámetros que inicializa el nodo vacío
    public NodoSE() {
        dato = null;          // Dato nulo
        suc = null;           // Siguiente nodo nulo
    }

    // Constructor que inicializa el nodo con un valor dado
    public NodoSE(T valor) {
        dato = valor;         // Asignar el valor al dato
        suc = new NodoSE();   // Crear un nuevo nodo vacío como siguiente nodo
    }

    // Método para obtener el dato del nodo
    public T getDato() {
        return dato;
    }

    // Método para obtener el siguiente nodo
    public NodoSE<T> getSuc() {
        return suc;
    }

    // Método para establecer el dato del nodo
    public void setDato(T valor) {
        dato = valor;
    }

    // Método para establecer el siguiente nodo
    public void setSuc(NodoSE<T> otro) {
        suc = otro;
    }

    // Método que verifica si el nodo está vacío (sin dato)
    public boolean vacio() {
        return dato == null; // Devuelve true si el dato es nulo
    }
}
