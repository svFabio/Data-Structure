package estDatLin;

/**
 * Clase que implementa una lista enlazada simple gen�rica.
 */
public class ListaSE<T> implements Lista<T> {
    // Campo que almacena el dato del nodo actual
    private T ini;
    // Campo que almacena la referencia al siguiente nodo en la lista
    private ListaSE<T> sig;

    // Constructor por defecto que inicializa una lista vac�a
    public ListaSE() {
        ini = null;
        sig = null;
    }

    // M�todo que verifica si la lista est� vac�a
    public boolean vacia() {
        return ini == null;
    }

    // M�todo para insertar un dato al final de la lista
    public void insertar(T dato) {
        if (vacia()) {
            ini = dato;
            sig = new ListaSE<T>();
        } else {
            sig.insertar(dato);
        }
    }

    // M�todo para insertar un dato en una posici�n espec�fica de la lista
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

    // M�todo para eliminar un dato en una posici�n espec�fica de la lista
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

    // M�todo para eliminar un dato espec�fico de la lista
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

    // M�todo para eliminar datos entre dos posiciones espec�ficas de la lista
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

    // M�todo para acceder al dato en una posici�n espec�fica de la lista
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

    // M�todo para acceder a un dato espec�fico en la lista
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

    // M�todo para buscar si un dato espec�fico existe en la lista
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

    // M�todo que devuelve la longitud de la lista
    public int longitud() {
        int longitud;
        if (vacia()) {
            longitud = 0;
        } else {
            longitud = 1 + sig.longitud();
        }
        return longitud;
    }

    // M�todo para vaciar la lista
    public void vaciar() {
        ini = null;
        sig = null;
    }

    // M�todo para reemplazar el dato en una posici�n espec�fica de la lista
    public void reemplazar(T dato, int pos) {
        if (!vacia()) {
            if (pos == 0) {
                ini = dato;
            } else {
                sig.reemplazar(dato, pos - 1);
            }
        }
    }

    // M�todo para dividir la lista en dos listas, una con la primera mitad de elementos y otra con la segunda mitad
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

    // M�todo privado recursivo para ayudar a dividir la lista en dos listas
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
    // M�todo para dividir la lista en dos, retornando una lista que contiene los elementos desde un dato espec�fico en adelante
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


