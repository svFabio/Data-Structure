package estDatLin;

/**
 * Esta interfaz define una lista gen�rica (Lista) con varios m�todos.
 */

public interface Lista<T> extends Coleccion<T> {
    // Verifica si la lista est� vac�a
    boolean vacia();
    
    // Inserta un elemento al final de la lista
    void insertar(T dato);

    // Inserta un elemento en una posici�n espec�fica de la lista
    void insertar(T dato, int pos);

    // Elimina un elemento en una posici�n espec�fica
    void eliminar(int pos);

    // Elimina un elemento espec�fico de la lista
    void eliminar(T dato);

    // Elimina elementos entre dos posiciones (pos1 y pos2)
    void eliminar(int pos1, int pos2);

    // Accede a un elemento en una posici�n espec�fica
    T acceder(int pos);

    // Accede a la primera ocurrencia de un elemento espec�fico
    T acceder(T dato);

    // Verifica si un elemento espec�fico existe en la lista
    boolean buscar(T dato);

    // Obtiene el n�mero de elementos en la lista
    int longitud();

    // Limpia toda la lista
    void vaciar();

    // Divide la lista en dos partes seg�n un elemento espec�fico
    Lista<T> dividir(T dato);

    // Reemplaza un elemento en una posici�n espec�fica
    void reemplazar(T dato, int pos);

    // Divide la lista en mitades (listas anidadas)
    Lista<Lista<T>> dividirMitad();
}
