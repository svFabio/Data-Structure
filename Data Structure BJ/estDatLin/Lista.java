package estDatLin;

/**
 * Esta interfaz define una lista genérica (Lista) con varios métodos.
 */

public interface Lista<T> extends Coleccion<T> {
    // Verifica si la lista está vacía
    boolean vacia();
    
    // Inserta un elemento al final de la lista
    void insertar(T dato);

    // Inserta un elemento en una posición específica de la lista
    void insertar(T dato, int pos);

    // Elimina un elemento en una posición específica
    void eliminar(int pos);

    // Elimina un elemento específico de la lista
    void eliminar(T dato);

    // Elimina elementos entre dos posiciones (pos1 y pos2)
    void eliminar(int pos1, int pos2);

    // Accede a un elemento en una posición específica
    T acceder(int pos);

    // Accede a la primera ocurrencia de un elemento específico
    T acceder(T dato);

    // Verifica si un elemento específico existe en la lista
    boolean buscar(T dato);

    // Obtiene el número de elementos en la lista
    int longitud();

    // Limpia toda la lista
    void vaciar();

    // Divide la lista en dos partes según un elemento específico
    Lista<T> dividir(T dato);

    // Reemplaza un elemento en una posición específica
    void reemplazar(T dato, int pos);

    // Divide la lista en mitades (listas anidadas)
    Lista<Lista<T>> dividirMitad();
}
