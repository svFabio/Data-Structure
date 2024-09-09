package estDatLin;

/**

Clase que representa una cola genérica (Cola) utilizando una lista doblemente enlazada.
*/
public class Cola<T> implements Coleccion<T> {
    protected NodoDE<T> frente; // Nodo al frente de la cola
    protected NodoDE<T> fin; // Nodo al final de la cola

    // Constructor que inicializa una cola vacía
    public Cola() {
        frente = fin = null;
    }

    // Método que verifica si la cola está vacía
    public boolean vacia() {
        return frente == null;
    }

    // Método para agregar un elemento al final de la cola
    public void encolar(T dato) {
        NodoDE<T> p;
        p = new NodoDE<T>(dato); // Crear un nuevo nodo con el dato
        if (vacia()) {
            frente = fin = p; // Si la cola está vacía, el nuevo nodo es tanto el frente como el fin
            } else {
            fin.setSuc(p); // Enlazar el nodo actual del final con el nuevo nodo
            p.setAnt(fin); // Enlazar el nuevo nodo con el nodo actual del final
            fin = p; // El nuevo nodo se convierte en el nodo del final
        }
    }

    // Método para remover y devolver el elemento al frente de la cola
    public T decolar() {
        T dato;
        if (vacia()) {
            dato = null; // Si la cola está vacía, devolver null
        }else{
            dato = frente.getDato(); // Obtener el dato del nodo al frente
            frente = frente.getSuc(); // Mover el frente al siguiente nodo
            if (frente == null) {
                fin = null; // Si la cola se vació, ajustar el fin a null
            } else {
                frente.setAnt(null); // Si no está vacía, eliminar el enlace al nodo anterior
            }
        }
        return dato;
    }

    // Método para ver el elemento al frente de la cola sin removerlo
    public T ver() {
        T dato;
        if (vacia()) {
            dato = null; // Si la cola está vacía, devolver null
        } else {
            dato = frente.getDato(); // Obtener el dato del nodo al frente
        }
        return dato;
    }
}