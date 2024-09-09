package estDatLin;
public class ListaCSE<T> implements Lista<T> {
    private NodoSE<T> ini;  // Nodo inicial de la lista

    // Constructor que inicializa la lista vacía
    public ListaCSE() {
        ini = new NodoSE<T>(); // Nodo inicial sin dato
        ini.setSuc(ini);       // El nodo inicial se apunta a sí mismo
    }

    // Método que verifica si la lista está vacía
    public boolean vacia() {
        return ini.vacio(); // Usa el método 'vacio' del nodo para verificar si está vacío
    }

    // Método para insertar un dato al final de la lista
    public void insertar(T dato) {
        if (vacia()) {
            ini.setDato(dato); // Si la lista está vacía, el nodo inicial toma el dato
        } else {
            NodoSE<T> nodoact = ini;
            // Recorrer hasta el último nodo
            while (nodoact.getSuc() != ini) {
                nodoact = nodoact.getSuc();
            }
            NodoSE<T> nuevo = new NodoSE<>(dato); // Crear nuevo nodo con el dato
            nodoact.setSuc(nuevo);                // El último nodo apunta al nuevo
            nuevo.setSuc(ini);                    // El nuevo nodo apunta al nodo inicial
        }
    }

    // Método para insertar un dato en una posición específica
    public void insertar(T dato, int pos) {
        int tam = longitud(); // Obtener la longitud de la lista
        if (pos <= tam) {
            if (vacia()) {
                ini = new NodoSE<T>(dato); // Si está vacía, el nodo inicial toma el dato
                ini.setSuc(ini);           // Y se apunta a sí mismo
            } else {
                if (pos == 0) {
                    NodoSE<T> lastini = ini;  // Guardar el nodo inicial actual
                    ini = new NodoSE<T>(dato); // El nuevo nodo inicial con el dato
                    ini.setSuc(lastini);      // El nuevo inicial apunta al anterior inicial
                } else {
                    NodoSE<T> buscado = buscar(pos - 1); // Buscar el nodo en la posición anterior
                    NodoSE<T> nuevo = new NodoSE<T>(dato); // Crear nuevo nodo con el dato
                    NodoSE<T> sigbuscado = buscado.getSuc(); // El nodo siguiente del buscado
                    buscado.setSuc(nuevo);    // El nodo anterior apunta al nuevo
                    NodoSE<T> nodonuevo = buscado.getSuc(); // Nuevo nodo
                    nodonuevo.setSuc(sigbuscado); // El nuevo nodo apunta al siguiente del buscado
                }
            }
        }
    }

    // Método para buscar un nodo en una posición específica
    public NodoSE<T> buscar(int pos) {
        NodoSE<T> nodoact = ini; // Nodo actual inicia en el nodo inicial
        int cont = 0;
        // Recorrer hasta la posición deseada
        while (cont < pos) {
            nodoact = nodoact.getSuc();
            cont++;
        }
        return nodoact; // Devolver el nodo encontrado
    }

    // Método para eliminar un nodo en una posición específica
    public void eliminar(int pos) {
        int tam = longitud(); // Obtener la longitud de la lista
        if (pos < tam && !vacia()) {
            if (tam == 1) {
                ini = new NodoSE<T>(); // Si solo hay un nodo, se reinicia la lista
                ini.setSuc(ini);       // Nodo inicial se apunta a sí mismo
            } else {
                if (pos == 0) {
                    ini = ini.getSuc(); // Eliminar el nodo inicial
                    NodoSE<T> nodolast = buscar(tam - 1); // Buscar el último nodo
                    nodolast.setSuc(ini); // El último nodo apunta al nuevo inicial
                } else {
                    NodoSE<T> nodoant = buscar(pos - 1); // Nodo anterior al eliminado
                    NodoSE<T> nodopost = buscar(pos + 1); // Nodo siguiente al eliminado
                    nodoant.setSuc(nodopost); // El nodo anterior apunta al siguiente
                }
            }
        }
    }

    // Método para eliminar un nodo por su dato
    public void eliminar(T dato) {
        NodoSE<T> nodobuscado = buscarDato(dato); // Buscar el nodo con el dato
        if (nodobuscado.getDato() != null) {
            int tam = longitud(); // Obtener la longitud de la lista
            if (tam == 1) {
                ini = new NodoSE<T>(); // Si solo hay un nodo, se reinicia la lista
                ini.setSuc(ini);       // Nodo inicial se apunta a sí mismo
            } else {
                if (nodobuscado == ini) {
                    ini = ini.getSuc(); // Eliminar el nodo inicial
                    NodoSE<T> nodolast = buscar(tam - 1); // Buscar el último nodo
                    nodolast.setSuc(ini); // El último nodo apunta al nuevo inicial
                } else {
                    NodoSE<T> nodoant = buscarAntDato(dato); // Nodo anterior al eliminado
                    NodoSE<T> nodopost = nodobuscado.getSuc(); // Nodo siguiente al eliminado
                    nodoant.setSuc(nodopost); // El nodo anterior apunta al siguiente
                }
            }
        }
    }

    // Método privado para buscar el nodo anterior al nodo con el dato dado
    private NodoSE<T> buscarAntDato(T dato) {
        NodoSE<T> nodoact = ini; // Nodo actual inicia en el nodo inicial
        while (nodoact.getSuc().getDato() != dato) {
            if (nodoact.getSuc().getSuc() == ini) break; // Si el siguiente es el inicial, salir
            nodoact = nodoact.getSuc();
        }
        if (nodoact.getSuc().getDato() == dato) return nodoact; // Devolver el nodo anterior encontrado
        else return new NodoSE<T>(); // Si no se encuentra, devolver un nodo vacío
    }

    // Método privado para buscar un nodo con el dato dado
    private NodoSE<T> buscarDato(T dato) {
        NodoSE<T> nodoact = ini; // Nodo actual inicia en el nodo inicial
        while (nodoact.getDato() != dato) {
            if (nodoact.getSuc() == ini) break; // Si el siguiente es el inicial, salir
            nodoact = nodoact.getSuc();
        }
        if (nodoact.getDato() == dato) return nodoact; // Devolver el nodo encontrado
        else return new NodoSE<T>(); // Si no se encuentra, devolver un nodo vacío
    }

    // Método para eliminar nodos entre dos posiciones
    public void eliminar(int pos1, int pos2) {
        int tam = longitud(); // Obtener la longitud de la lista
        if (pos1 <= pos2 && pos1 >= 0 && pos1 < tam && pos2 >= 0 && pos2 < tam) {
            if (pos1 == 0) {
                NodoSE<T> nodobuscadopos2 = buscar(pos2); // Buscar el nodo en la posición final
                ini = nodobuscadopos2.getSuc(); // El nuevo inicial es el siguiente al final
                tam = longitud(); // Obtener la nueva longitud
                NodoSE<T> nodolast = buscar(tam - 1); // Buscar el último nodo
                nodolast.setSuc(ini); // El último nodo apunta al nuevo inicial
            } else {
                NodoSE<T> nodoant = buscar(pos1 - 1); // Nodo anterior al primer eliminado
                NodoSE<T> nodopost = buscar(pos2 + 1); // Nodo siguiente al último eliminado
                nodoant.setSuc(nodopost); // El nodo anterior apunta al siguiente
            }
        }
    }

    // Método para acceder a un dato en una posición específica
    public T acceder(int pos) {
        T dato = null;
        int tam = longitud(); // Obtener la longitud de la lista
        if (pos < tam) {
            NodoSE<T> nodobuscado = buscar(pos); // Buscar el nodo en la posición
            dato = nodobuscado.getDato(); // Obtener el dato del nodo
        }
        return dato;
    }

    // Método para acceder a un nodo con un dato específico
    public T acceder(T dato) {
        NodoSE<T> nodobuscado = buscarDato(dato); // Buscar el nodo con el dato
        T ans = null;
        if (nodobuscado.getDato() != null) {
            ans = nodobuscado.getDato(); // Si se encuentra, devolver el dato
        }
        return ans;
    }

    // Método para buscar si un dato existe en la lista
    public boolean buscar(T dato) {
        NodoSE<T> nodobuscado = buscarDato(dato); // Buscar el nodo con el dato
        return nodobuscado.getDato() != null; // Devolver verdadero si se encuentra
    }

    // Método para obtener la longitud de la lista
    public int longitud() {
        if (vacia()) return 0; // Si está vacía, la longitud es 0
        else {
            NodoSE<T> nodoact = ini;
            int tam = 1;
            while (nodoact.getSuc() != ini) { // Recorrer hasta volver al inicial
                tam++;
                nodoact = nodoact.getSuc();
            }
            return tam; // Devolver la longitud
        }
    }

    // Método para vaciar la lista
    public void vaciar() {
        ini = new NodoSE<T>(); // Reiniciar el nodo inicial
        ini.setSuc(ini);       // Nodo inicial se apunta a sí mismo
    }

    // Método para reemplazar un dato en una posición específica
    public void reemplazar(T dato, int pos) {
        int tam = longitud(); // Obtener la longitud de la lista
        if (pos < tam) {
            NodoSE<T> nodobuscado = buscar(pos); // Buscar el nodo en la posición
            nodobuscado.setDato(dato); // Reemplazar el dato
        }
    }

    // Método para dividir la lista en dos mitades
    public Lista<Lista<T>> dividirMitad() {
        Lista<Lista<T>> listas = new ListaCSE<Lista<T>>(); // Crear una lista de listas
        listas.insertar(new ListaCSE<T>()); // Insertar la primera lista
        listas.insertar(new ListaCSE<T>()); // Insertar la segunda lista
        if (!vacia()) {
            dividir(listas.acceder(0), listas.acceder(1)); // Dividir la lista original en dos
        }
        return listas; // Devolver la lista de listas
    }
    // Método para dividir la lista en dos a partir de un dato dado
    public Lista<T> dividir(T dato) {
        if (vacia() || !buscar(dato)) {
            return null; // Si está vacía o no se encuentra el dato, devolver null
        } else {
            ListaCSE<T> nuevalista = new ListaCSE<T>(); // Crear una nueva lista
            NodoSE<T> nodoact = ini;
            while (nodoact.getDato() != dato) { // Recorrer hasta el dato
                nuevalista.insertar(nodoact.getDato()); // Insertar en la nueva lista
                nodoact = nodoact.getSuc();
            }
            nuevalista.insertar(dato); // Insertar el dato en la nueva lista
            return nuevalista; // Devolver la nueva lista
        }
    }

    // Método privado para dividir la lista en dos listas dadas
    private void dividir(Lista<T> lista1, Lista<T> lista2) {
        int tam = longitud(), mitad = (tam + 1) / 2, cont = 0; // Calcular la mitad
        NodoSE<T> nodoact = ini;
        while (cont < mitad) { // Insertar la primera mitad en la primera lista
            lista1.insertar(nodoact.getDato());
            cont++;
            nodoact = nodoact.getSuc();
        }
        while (cont < tam) { // Insertar la segunda mitad en la segunda lista
            lista2.insertar(nodoact.getDato());
            cont++;
            nodoact = nodoact.getSuc();
        }
    }
}
