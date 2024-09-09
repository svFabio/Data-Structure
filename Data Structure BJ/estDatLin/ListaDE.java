package estDatLin;

/**
 * Clase que representa una lista doblemente enlazada (ListaDE) genérica.
 */
public class ListaDE<T> implements Lista<T> {
    private ListaDE<T> ant; // empezarai null
    private NodoDE<T>  ini;  // Nodo inicial de la lista
    private ListaDE<T> sig;
    // Constructor que inicializa la lista con un nodo vacío
    public ListaDE() {
        ini = new NodoDE<T>();
    }

    // Método que verifica si la lista está vacía
    public boolean vacia() {
        //return false;
        return ini.nodoVacio();
    }

    // Método para insertar un dato al final de la lista
    public void insertar(T dato) {
        NodoDE<T> act = ini;
        while (!act.nodoVacio()) {  // Buscar el último nodo no vacío
            act = act.getSuc();
        }
        act.setDato(dato);
        act.setSuc(new NodoDE<T>());  // Crear un nuevo nodo vacío al final
        NodoDE<T> sig = act.getSuc();
        sig.setAnt(act);  // Establecer el enlace al nodo anterior
    }

    // Método para insertar un dato en una posición específica de la lista
    public void insertar(T dato, int pos) {
        NodoDE<T> newNodo = new NodoDE<T>(dato);
        if (vacia()) {
            ini = newNodo;
            ini.setSuc(new NodoDE<T>());
        } else {
            if (pos == 0) {
                NodoDE<T> nodopost = buscar(ini, pos);
                ini = newNodo;
                ini.setSuc(nodopost);
            } else {
                NodoDE<T> nodopost = buscar(ini, pos);
                NodoDE<T> ant = nodopost.getAnt();
                ant.setSuc(newNodo);
                nodopost.setAnt(newNodo);
                NodoDE<T> nodometido = nodopost.getAnt();
                nodometido.setSuc(nodopost);
                nodometido.setAnt(ant);
            }
        }
    }

    // Método privado para buscar un nodo en una posición específica
    private NodoDE<T> buscar(NodoDE<T> inic, int pos) {
        NodoDE<T> nodo = inic;
        int posact = 0;
        while (posact < pos) {
            nodo = nodo.getSuc();
            posact++;
        }
        return nodo;
    }

    // Método para eliminar un nodo en una posición específica
    public void eliminar(int pos) {
        if (pos == 0) {
            ini = ini.getSuc();
            ini.setAnt(null);
        } else {
            NodoDE<T> nodo = buscar(ini, pos);
            NodoDE<T> post = nodo.getSuc();
            NodoDE<T> ant = nodo.getAnt();
            ant.setSuc(post);
            post.setAnt(ant);
        }
    }

    // Método para eliminar un nodo que contiene un dato específico
    public void eliminar(T dato) {
        if (!vacia()) {
            NodoDE<T> buscado = buscar(ini, dato);
            if (!buscado.nodoVacio()) {
                if (buscado == ini) {
                    ini = ini.getSuc();
                    ini.setAnt(null);
                } else {
                    NodoDE<T> post = buscado.getSuc();
                    NodoDE<T> ant = buscado.getAnt();
                    ant.setSuc(post);
                    post.setAnt(ant);
                }
            }
        }
    }

    // Método privado para buscar un nodo que contiene un dato específico
    private NodoDE<T> buscar(NodoDE<T> inic, T dato) {
        NodoDE<T> act = inic;
        while (!act.nodoVacio()) {
            if (act.getDato().equals(dato)) {
                break;
            }
            act = act.getSuc();
        }
        return act;
    }

    // Método para eliminar un rango de nodos (de pos1 a pos2)
    public void eliminar(int pos1, int pos2) {
        if (!vacia()) {
            if (pos1 == 0) {
                NodoDE<T> nodopos2 = buscar(ini, pos2);
                ini = nodopos2.getSuc();
                ini.setAnt(null);
            } else {
                NodoDE<T> buscado = buscar(ini, pos1);
                NodoDE<T> buscado2 = buscar(ini, pos2);
                NodoDE<T> antbuscado = buscado.getAnt();
                NodoDE<T> postbuscado2 = buscado2.getSuc();
                antbuscado.setSuc(postbuscado2);
                postbuscado2.setAnt(antbuscado);
            }
        }
    }

    // Método para acceder a un dato en una posición específica
    public T acceder(int pos) {
        //return null;
        T ans = null;
        if (!vacia()) {
            NodoDE<T> buscado = buscar(ini, pos);
            if (buscado.nodoVacio()) {
                ans = null;
            } else {
                ans = buscado.getDato();
            }
        }
        return ans;
    }

    // Método para acceder a un dato (no implementado en esta versión)
    /*private T acceder(T dato) {
        return null;
    }*/
    public T acceder(T dato) {
        NodoDE<T> actual = ini;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual.getDato();
            }
            actual = actual.getSuc();
        }
        return null;
    }

    // Método para buscar un dato en la lista
    public boolean buscar(T dato) {
        //return false;
        NodoDE<T> act = ini;
        boolean bo = false;
        while (!act.nodoVacio()) {
            if (act.getDato() == dato) {
                bo = true;
            }
            act = act.getSuc();
        }
        return bo;
    }

    // Método para obtener la longitud de la lista
    public int longitud() {
        int len = 0;
        NodoDE<T> act = ini;
        while (!act.nodoVacio()) {
            len++;
            act = act.getSuc();
        }
        return len;
    }

    // Método para vaciar la lista
    public void vaciar() {
        ini = new NodoDE<T>();
    }

    // Método para reemplazar el dato en una posición específica
    public void reemplazar(T dato, int pos) {
        if (pos < longitud()) {
            NodoDE<T> nodobuscado = buscar(ini, pos);
            nodobuscado.setDato(dato);
        }
    }

    /** 1.- (4 puntos) Dada una lista de doble enlace, implementar un método el cual elimine los
        duplicados de la lista. Por ejemplo, si la lista.  si la lista tiene los siguientes elementos
        {2,3,4,5,3,4,6,7,4,5,3,9,1,1} se tiene que volver {2,3,4,5,6,7,9,1} El método principal deberá
        tener la siguiente firma: eliminarDuplicados(ListaDE<T> lista) : ListaDE<T>*/
        
    public ListaDE<T> eliminarDuplicados(ListaDE<T> lista) {
        // nodo inicial
        NodoDE<T> actual = ini;
        while (actual != null && actual.getSuc() != null) { 
            
            NodoDE<T> NodoActual = actual;
            while (NodoActual.getSuc() != null) {
                
                if (actual.getDato().equals(NodoActual.getSuc().getDato())) { 
                    NodoActual.setSuc(NodoActual.getSuc().getSuc());
                } else {
                       
                    NodoActual = NodoActual.getSuc();
                }
            }
        
            actual = actual.getSuc();
        }
        return lista;
        
    }
    
    // Método para dividir la lista en dos mitades
    public Lista<Lista<T>> dividirMitad() {
        //return null;
        Lista<Lista<T>> listas = new ListaDE<Lista<T>>();
        listas.insertar(new ListaDE<T>());
        listas.insertar(new ListaDE<T>());
        if (!vacia()) {
            dividir(listas.acceder(0), listas.acceder(1));
        }
        return listas;
    }

    // Método privado para dividir la lista en dos listas proporcionadas
    private void dividir(Lista<T> lista1, Lista<T> lista2) {
        int tam = longitud();
        int mitad = (tam + 1) / 2;
        int cont = 0;
        NodoDE<T> act = ini;
        while (cont < mitad) {
            lista1.insertar(act.getDato());
            cont++;
            act = act.getSuc();
        }
        while (cont < tam) {
            lista2.insertar(act.getDato());
            cont++;
            act = act.getSuc();
        }
    }
    
    public Lista<T> dividir(T dato) {
        if (vacia() || !buscar(dato)) {
            return null;
        } else {
            ListaDE<T> listaans = new ListaDE<T>();
            NodoDE<T> act = ini;
            while (act.getDato() != dato) {
                listaans.insertar(act.getDato());
                act = act.getSuc();
            }
            listaans.insertar(dato);
            return listaans;
        }
    }
}
        
        
        
    
