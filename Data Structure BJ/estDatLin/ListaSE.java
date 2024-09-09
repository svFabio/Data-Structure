package estDatLin;

/**
 * Clase que implementa una lista enlazada simple genérica.
 */
public class ListaSE<T> implements Lista<T> {
    // Campo que almacena el dato del nodo actual
    private T ini;
    // Campo que almacena la referencia al siguiente nodo en la lista
    private ListaSE<T> sig;

    // Constructor por defecto que inicializa una lista vacía
    public ListaSE() {
        ini = null;
        sig = null;
    }

    // Método que verifica si la lista está vacía
    public boolean vacia() {
        return ini == null;
    }

    // Método para insertar un dato al final de la lista
    public void insertar(T dato) {
        if (vacia()) {
            ini = dato;
            sig = new ListaSE<T>();
        } else {
            sig.insertar(dato);
        }
    }

    // Método para insertar un dato en una posición específica de la lista
    public void insertar(T dato, int pos) {
        if (vacia()) {
            if (pos == 0) {
                ini = dato;
                sig = new ListaSE<T>();
            }
        } else {
            if (pos == 0) {
                sig.insertar(ini, 0);
                ini = dato;
            } else {
                sig.insertar(dato, pos - 1);
            }
        }
    }

    // Método para eliminar un dato en una posición específica de la lista
    public void eliminar(int pos) {
        if (!vacia()) {
            if (pos == 0) {
                ini = sig.ini;
                sig = sig.sig;
            } else {
                sig.eliminar(pos - 1);
            }
        }
    }

    // Método para eliminar un dato específico de la lista
    public void eliminar(T dato) {
        if (!vacia()) {
            if (ini.equals(dato)) {
                ini = sig.ini;
                sig = sig.sig;
            } else {
                sig.eliminar(dato);
            }
        }
    }

    // Método para eliminar datos entre dos posiciones específicas de la lista
    public void eliminar(int pos1, int pos2) {
        if (!vacia()) {
            if (pos1 == 0) {
                if (pos2 == 0) {
                    ini = sig.ini;
                    sig = sig.sig;
                } else {
                    ini = sig.ini;
                    sig = sig.sig;
                    eliminar(pos1, pos2 - 1);
                }
            } else {
                sig.eliminar(pos1 - 1, pos2 - 1);
            }
        }
    }

    // Método para acceder al dato en una posición específica de la lista
    public T acceder(int pos) {
        T dato;
        if (vacia()) {
            dato = null;
        } else {
            if (pos == 0) {
                dato = ini;
            } else {
                dato = sig.acceder(pos - 1);
            }
        }
        return dato;
    }

    // Método para acceder a un dato específico en la lista
    public T acceder(T dato) {
        T datoR;
        if (vacia()) {
            datoR = null;
        } else {
            if (ini.equals(dato)) {
                datoR = ini;
            } else {
                datoR = sig.acceder(dato);
            }
        }
        return datoR;
    }

    // Método para buscar si un dato específico existe en la lista
    public boolean buscar(T dato) {
        boolean hay;
        if (vacia()) {
            hay = false;
        } else {
            if (ini.equals(dato)) {
                hay = true;
            } else {
                hay = sig.buscar(dato);
            }
        }
        return hay;
    }

    // Método que devuelve la longitud de la lista
    public int longitud() {
        int longitud;
        if (vacia()) {
            longitud = 0;
        } else {
            longitud = 1 + sig.longitud();
        }
        return longitud;
    }

    // Método para vaciar la lista
    public void vaciar() {
        ini = null;
        sig = null;
    }

    // Método para reemplazar el dato en una posición específica de la lista
    public void reemplazar(T dato, int pos) {
        if (!vacia()) {
            if (pos == 0) {
                ini = dato;
            } else {
                sig.reemplazar(dato, pos - 1);
            }
        }
    }

    // Método para dividir la lista en dos listas, una con la primera mitad de elementos y otra con la segunda mitad
    public Lista<Lista<T>> dividirMitad() {
        Lista<Lista<T>> listas = new ListaSE<Lista<T>>();
        listas.insertar(new ListaSE<T>());
        listas.insertar(new ListaSE<T>());
        int[] cantidades = new int[3];
        if (!vacia()) {
            dividir(listas.acceder(0), listas.acceder(1), cantidades);
        }
        return listas;
    }

    // Método privado recursivo para ayudar a dividir la lista en dos listas
    private void dividir(Lista<T> lis1, Lista<T> lis2, int[] cants) {
        if (vacia()) {
            cants[1] = cants[0] - cants[0] / 2;
            cants[2] = cants[0] / 2;
        } else {
            cants[0]++;
            sig.dividir(lis1, lis2, cants);
            if (cants[2] > 0) {
                lis2.insertar(ini, 0);
                cants[2]--;
            } else {
                if (cants[1] > 0) {
                    lis1.insertar(ini, 0);
                    cants[1]--;
                }
            }
        }
    }
    // Método para dividir la lista en dos, retornando una lista que contiene los elementos desde un dato específico en adelante
    public Lista<T> dividir(T dato) {
        Lista<T> listaR = new ListaSE<T>();
        if (!vacia()) {
            if (ini.equals(dato)) {
                listaR.insertar(ini);
            } else {
                listaR = sig.dividir(dato);
                if (!listaR.vacia()) {
                    listaR.insertar(ini, 0);
                }
            }
        }
        return listaR;
    }
}


