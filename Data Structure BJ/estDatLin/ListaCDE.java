package estDatLin;
public class ListaCDE<T> implements Lista<T> {
    // Nodo inicial de la lista
    private NodoDE<T> ini;

    // Constructor por defecto que inicializa una lista vacía
    public ListaCDE() {
        ini = null;
    }

    // Método que verifica si la lista está vacía
    public boolean vacia() {
        return ini == null;
    }

    // Método para insertar un dato al final de la lista
    public void insertar(T dato) {
        NodoDE<T> p, ult;
        p = new NodoDE<T>(dato); // Crear un nuevo nodo con el dato

        if (vacia()) {
            ini = p;
            p.setSuc(p); // El nodo apunta a sí mismo
            p.setAnt(p); // El nodo apunta a sí mismo
        } else {
            ult = ini.getAnt(); // Obtener el último nodo
            ult.setSuc(p); // El último nodo apunta al nuevo nodo
            p.setAnt(ult); // El nuevo nodo apunta al último nodo
            p.setSuc(ini); // El nuevo nodo apunta al nodo inicial
            ini.setAnt(p); // El nodo inicial apunta al nuevo nodo
        }
    }

    // Método para insertar un dato en una posición específica de la lista
    public void insertar(T dato, int pos) {
        NodoDE<T> p, q, r;
        p = new NodoDE<T>(dato); // Crear un nuevo nodo con el dato

        if (vacia()) {
            ini = p;
            p.setSuc(p); // El nodo apunta a sí mismo
            p.setAnt(p); // El nodo apunta a sí mismo
        } else {
            q = buscar(ini, pos); // Encontrar el nodo en la posición `pos`
            r = q.getAnt(); // Obtener el nodo anterior a `q`
            r.setSuc(p); // El nodo anterior apunta al nuevo nodo
            p.setAnt(r); // El nuevo nodo apunta al nodo anterior
            p.setSuc(q); // El nuevo nodo apunta a `q`
            q.setAnt(p); // `q` apunta al nuevo nodo
            if (pos == 0) {
                ini = p; // Si `pos` es 0, actualizar el nodo inicial
            }
        }
    }

    // Método auxiliar para buscar un nodo en una posición específica
    private NodoDE<T> buscar(NodoDE<T> q, int pos) {
        NodoDE<T> nodo;
        if (pos == 0) {
            nodo = q;
        } else {
            nodo = buscar(q.getSuc(), pos - 1); // Búsqueda recursiva
        }
        return nodo;
    }

    // Método auxiliar para buscar un nodo con un dato específico
    private NodoDE<T> buscar(NodoDE<T> q, T dato) {
        NodoDE<T> nodo;
        if (q.getDato().equals(dato)) {
            nodo = q;
        } else {
            if (q.getSuc() == ini) {
                nodo = null; // Si se da la vuelta a la lista y no se encuentra el dato
            } else {
                nodo = buscar(q.getSuc(), dato); // Búsqueda recursiva
            }
        }
        return nodo;
    }

    // Método para eliminar un nodo en una posición específica
    public void eliminar(int pos) {
        NodoDE<T> q, r, s;
        if (!vacia()) {
            q = buscar(ini, pos); // Encontrar el nodo en la posición `pos`
            r = q.getAnt(); // Nodo anterior a `q`
            s = q.getSuc(); // Nodo siguiente a `q`
            r.setSuc(s); // El nodo anterior apunta al nodo siguiente
            s.setAnt(r); // El nodo siguiente apunta al nodo anterior
            if (q == ini) {
                ini = s; // Si `q` es el inicial, actualizar `ini`
            }
            if (q == s) { // Caso especial si `q` es el único nodo en la lista
                ini = null; // Lista vacía
            }
        }
    }

    // Método para eliminar un nodo con un dato específico
    public void eliminar(T dato) {
        NodoDE<T> q, r, s;
        if (!vacia()) {
            q = buscar(ini, dato); // Buscar el nodo con el dato
            if (q != null) {
                r = q.getAnt(); // Nodo anterior a `q`
                s = q.getSuc(); // Nodo siguiente a `q`
                r.setSuc(s); // El nodo anterior apunta al nodo siguiente
                s.setAnt(r); // El nodo siguiente apunta al nodo anterior
                if (q == ini) {
                    ini = s; // Si `q` es el inicial, actualizar `ini`
                }
                if (q == s) { // Caso especial si `q` es el único nodo en la lista
                    ini = null; // Lista vacía
                }
            }
        }
    }

    /*
     * Elimina los nodos desde `pos1` hasta `pos2` (inclusive).
     * pos1 <= pos2
     */
    public void eliminar(int pos1, int pos2) {
        NodoDE<T> q;
        if (!vacia()) {
            q = buscar(ini, pos1); // Encontrar el nodo en `pos1`
            eliminar(q, pos2 - pos1 + 1); // Eliminar `pos2 - pos1 + 1` nodos desde `q`
        }
    }

    // Método auxiliar para eliminar `cant` nodos a partir de `q`
    private void eliminar(NodoDE<T> q, int cant) {
        NodoDE<T> r, s;
        if (!vacia()) {
            if (cant > 0) {
                r = q.getAnt(); // Nodo anterior a `q`
                s = q.getSuc(); // Nodo siguiente a `q`
                r.setSuc(s); // El nodo anterior apunta al nodo siguiente
                s.setAnt(r); // El nodo siguiente apunta al nodo anterior
                if (q == ini) {
                    ini = s; // Si `q` es el inicial, actualizar `ini`
                }
                if (q == s) { // Caso especial si `q` es el único nodo en la lista
                    ini = null; // Lista vacía
                }
                eliminar(q.getSuc(), cant - 1); // Recursivamente eliminar el siguiente nodo
            }
        }
    }

    // Método para acceder al dato en una posición específica de la lista
    public T acceder(int pos) {
        T dato;
        NodoDE<T> q;
        if (vacia()) {
            dato = null; // Si la lista está vacía, devolver null
        } else {
            q = buscar(ini, pos); // Buscar el nodo en `pos`
            dato = q.getDato(); // Obtener el dato del nodo
        }
        return dato;
    }

    // Método para acceder a un dato específico en la lista
    public T acceder(T dato) {
        T datoR;
        NodoDE<T> q;
        if (vacia()) {
            datoR = null; // Si la lista está vacía, devolver null
        } else {
            q = buscar(ini, dato); // Buscar el nodo con el dato
            if (q == null) {
                datoR = null; // Si no se encuentra, devolver null
            } else {
                datoR = q.getDato(); // Devolver el dato del nodo encontrado
            }
        }
        return datoR;
    }

    // Método para buscar si un dato específico existe en la lista
    public boolean buscar(T dato) {
        boolean existe;
        NodoDE<T> q;
        if (vacia()) {
            existe = false; // Si la lista está vacía, el dato no existe
        } else {
            q = buscar(ini, dato); // Buscar el nodo con el dato
            existe = q != null; // Verificar si el nodo fue encontrado
        }
        return existe;
    }

    // Método que devuelve la longitud de la lista
    public int longitud() {
        int longitud;
        if (vacia()) {
            longitud = 0; // Si la lista está vacía, la longitud es 0
        } else {
            longitud = contar(ini); // Contar los nodos de la lista
        }
        return longitud;
    }

    // Método auxiliar para contar los nodos en la lista
    private int contar(NodoDE<T> q) {
        int contador;
        if (q.getSuc() == ini) {
            contador = 1; // Si se da la vuelta a la lista, contar 1 nodo
        } else {
            contador = 1 + contar(q.getSuc()); // Recursivamente contar los nodos
        }
        return contador;
    }

    // Método para vaciar la lista
    public void vaciar() {
        ini = null; // Establecer `ini` a null, eliminando referencias a todos los nodos
    }

    // Método para dividir la lista desde un dato específico en adelante
    public Lista<T> dividir(T dato) {
        Lista<T> listaR = new ListaCDE<T>();
        if (!vacia()) {
            copiar(ini, dato, listaR); // Copiar nodos a la nueva lista
        }
        return listaR;
    }

    // Método auxiliar para copiar nodos desde `q` hasta encontrar `dato`
    private void copiar(NodoDE<T> q, T dato, Lista<T> lista) {
        if (q.getDato().equals(dato)) {
            lista.insertar(q.getDato()); // Insertar nodo en la nueva lista
        } else {
            lista.insertar(q.getDato()); // Insertar nodo en la nueva lista
            if (q.getSuc() == ini) {
                lista.vaciar(); // Si se da la vuelta a la lista, vaciar la nueva lista
            } else {
                copiar(q.getSuc(), dato, lista); // Recursivamente copiar los nodos
            }
        }
    }

    // Método para reemplazar el dato en una posición específica de la lista
    public void reemplazar(T dato, int pos) {
        NodoDE<T> q;
        if (!vacia()) {
            q = buscar(ini, pos); // Buscar el nodo en `pos`
            q.setDato(dato); // Reemplazar el dato del nodo
        }
    }

    // Método para dividir la lista en dos listas, una con la primera mitad de elementos y otra con la segunda mitad
    public Lista<Lista<T>> dividirMitad() {
        Lista<Lista<T>> listas = new ListaCDE<Lista<T>>();
        listas.insertar(new ListaCDE<T>()); // Primera mitad
        listas.insertar(new ListaCDE<T>()); // Segunda mitad
        if (!vacia()) {
            dividir(ini, ini.getAnt(), listas.acceder(0), listas.acceder(1)); // Dividir la lista
        }
        return listas;
    }

    // Método auxiliar para dividir la lista en dos mitades
    private void dividir(NodoDE<T> q, NodoDE<T> p, Lista<T> lis1, Lista<T> lis2) {
        if (q == p) {
            lis1.insertar(q.getDato()); // Si `q` es igual a `p`, insertar en la primera lista
        } else {
            if (q == ini) {
                lis1.insertar(q.getDato()); // Insertar en la primera lista
                lis2.insertar(p.getDato(), 0); // Insertar en la segunda lista
                dividir(q.getSuc(), p.getAnt(), lis1, lis2); // Recursivamente dividir
            } else {
                if (q.getAnt() != p) {
                    lis1.insertar(q.getDato()); // Insertar en la primera lista
                    lis2.insertar(p.getDato(), 0); // Insertar en la segunda lista
                    dividir(q.getSuc(), p.getAnt(), lis1, lis2); // Recursivamente dividir
                }
            }
        }
    }
}
