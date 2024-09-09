package estDatNoLin;
import estDatLin.*;
public class ArbolBin<T>{
    
    private ArbolBin<T> izq;
    private T           raiz;
    private ArbolBin<T> der;
    
    public ArbolBin(){
        raiz = null;
        izq = null;
        der = null;
    }
    
    public ArbolBin(T r){
        raiz = r;
        izq = null;
        der = null;
    }
    
    public ArbolBin(T r, ArbolBin<T> i, ArbolBin<T> d){
        raiz = r;
        izq =  i;
        der =  d;
    }
    
    public ArbolBin<T> ArbolDer(){
        return der;
    }
    
    public ArbolBin<T> ArbolIzq(){
        return izq; 
    }
    
    public T accederRaiz(){
        return raiz;
    }
    
    public T acceder(T dato){
        T elDato;
        if(!vacia()){
            elDato = null;
        }else{
            if(raiz.equals(dato)){
                elDato = raiz;
            }else{
                elDato = izq.acceder(dato);
                if(elDato == null){
                    elDato = der.acceder(dato);
                }
            }
        }
        return elDato;
    }
    
    public boolean vacia(){
        return raiz == null;
    }
    
    public boolean insertar(T dato, ListaSE<T> ruta){
        boolean sePudo;
        T r1;
        if(vacia()){
            if(ruta.vacia()){
                sePudo = true;
                raiz = dato;
                izq = new ArbolBin<T>();
                der = new ArbolBin<T>();
            }else{
                sePudo = false;
            }
        }else{
            if(ruta.vacia()){
                sePudo = false;
            }else{
                r1 = ruta.acceder(0);
                ruta.eliminar(0);
                if(r1.equals(raiz)){
                    sePudo = izq.insertar(dato, ruta);
                    if(!sePudo){
                        sePudo = der.insertar(dato, ruta);
                    }
                }else{
                    sePudo = false;
                }
                ruta.insertar(r1, 0);
            }
        }
        return sePudo;
    }
    
    /**Insert Por amplitud*/
    public void insertar(T dato){
        Cola<ArbolBin<T>> cola;
        cola = new Cola<ArbolBin<T>>();
        cola.encolar(this);
        insertar(dato, cola);
    }
    
    private void insertar(T dato, Cola<ArbolBin<T>> cola){
        ArbolBin<T> arb;
        arb = cola.decolar();
        if(arb.vacia()){
            arb.raiz = dato;
            arb.izq = new ArbolBin<T>();
            arb.der = new ArbolBin<T>();
        }else{
            cola.encolar(arb.izq);
            cola.encolar(arb.der);
            insertar(dato,cola);
        }
    }
    
    public boolean eliminar(T dato){
        boolean sePudo;
        if(vacia()){
            sePudo = false;
        }else{
            if(raiz.equals(dato)){
                if(izq.vacia() && der.vacia()){
                    sePudo = true;
                    raiz = null;
                    izq = null;
                    der = null;
                }else{
                    sePudo = false;
                }
            }else{
                sePudo = izq.eliminar(dato);
                if(!sePudo){
                    sePudo = der.eliminar(dato);
                }
            }
        }
        return sePudo;
    }
    
    /*
    public Lista<T> inorden(){
        Lista<T> lista;
        lista = new ListaSE<T>();
        if(!vacia()){
            lista.insertar(izq.inorden());
            lista.insertar(raiz);
            lista.insertar(der.inorden());
        }
        return lista;
    }*/
    
    
    public int nroHojas(){
        int hojas;
        if(vacia()){
            hojas = 0;
        }else{
            if(izq.vacia() && der.vacia()){
                hojas = 1;
            }else{
                hojas = izq.nroHojas() + der.nroHojas();
            }
        }
        return hojas;
    }
    
    public Lista<T> ramaMasLarga(){
        Lista<T> rama;
        rama = new ListaSE<T>();
        if(!vacia()){
            rama = larga(izq.ramaMasLarga(), der.ramaMasLarga());
            rama.insertar(raiz,0);
        }
        return rama;
    }
    
    private Lista<T> larga(Lista<T> ri, Lista<T> rd){
        Lista<T> r;
        r = ri.longitud() < rd.longitud()? rd: ri;
        return r;
    }
    
    public int nivel(T dato){
        int nivel;
        if(vacia()){
            nivel = -1;
        }else{
            if(raiz.equals(dato)){
                nivel = 0;
            }else{
                nivel = izq.nivel(dato);
                if(nivel == -1){
                    nivel = der.nivel(dato);
                }
                if(nivel != -1){
                    nivel ++;
                }
            }
        }
        return nivel;
    }
    
    // Dado un T dato busca la ruta del mismo en un arbol
    public ListaSE<T> ruta(ArbolBin<T> arbol, T dato){
        ListaSE<T> lista = new ListaSE<T>();
        if(arbol.raiz == null){return lista;}
        if(arbol.raiz == dato){
            lista.insertar(arbol.raiz);
            return lista;
        }
        ListaSE<T> lista1 = ruta(arbol.izq, dato);
        if(lista1.longitud() > 0){
            lista1.insertar(arbol.raiz, 0);
            return lista1;
        }else{
            ListaSE<T> lista2 = ruta(arbol.der, dato);
            if(lista2.longitud() > 0){
                lista2.insertar(arbol.raiz, 0);
                return lista2;
            }
        }
        return lista;
    }
    
    // si es parcialmente vacio entonces false, si es parcialmente lleno true
    public boolean parcialmente(ArbolBin<T> arbol){
        Cola<ArbolBin<T>> cola = new Cola<ArbolBin<T>>();
        cola.encolar(arbol);
        boolean res = true, boaux = true;
        while(!cola.vacia()){
            ArbolBin<T> arbolTope = cola.decolar();
            if(arbolTope.raiz == null){
                boaux = false;
            }
            else{
                if(!boaux){   
                    res = false;
                }
                cola.encolar(arbol.izq);
                cola.encolar(arbol.der);
            }
        }
        return res;
    }
        
        public boolean samefringe(ArbolBin<T> arbol1, ArbolBin<T> arbol2){
        // Crear listas para almacenar las hojas de los dos árboles
        ListaSE<T> lista1 = new ListaSE<T>();
        ListaSE<T> lista2 = new ListaSE<T>();
        
        // Llenar las listas con las hojas de cada árbol
        ordenHojas(arbol1, lista1);
        ordenHojas(arbol2, lista2);
        
        // Obtener la longitud de ambas listas
        int tam1 = lista1.longitud(), tam2 = lista2.longitud();
        
        // Inicializar el resultado como verdadero
        boolean res = true;
        
        // Si las longitudes de las listas son iguales, comparar los elementos
        if(tam1 == tam2){
            for(int i = 0; i < lista1.longitud(); i++){
                // Si algún elemento en las listas no es igual, establecer el resultado en falso
                if(lista1.acceder(i) != lista2.acceder(i)) res = false;
            }
        }   
        // Devolver el resultado de la comparación
        return res;
    }
    
    public void ordenHojas(ArbolBin<T> arbol, ListaSE<T> lista){
        // Si el nodo actual es una hoja (no tiene hijos), agregar su valor a la lista
        if(arbol.izq.raiz == null && arbol.der.raiz == null){
            lista.insertar(arbol.raiz);
            return;
        }
        // Recorrer recursivamente los subárboles izquierdo y derecho
        ordenHojas(arbol.izq, lista);
        ordenHojas(arbol.der, lista);
    }
    
    
    public boolean estructuralmenteIgual(ArbolBin<T> otro){
        boolean res = false;
        if(raiz != null && otro.accederRaiz() != null ){
            if(der != null && otro.der!=null){
                boolean derecha = true;
                if(der!=null && otro.der!=null){
                    derecha = der.estructuralmenteIgual(otro.ArbolDer());
                }
        
                if (derecha){
                   if(izq != null && otro.izq!=null){
                      boolean izquierda = true;
                      if(izq!=null && otro.izq!=null){
                           izquierda = izq.estructuralmenteIgual(otro.ArbolIzq());
                      }
                      res = izquierda;
                   }
                }   
           }
        }else{
            if(raiz == null && otro.accederRaiz()==null) res = true;
        }
        return res;
    }
    
    public boolean espejo(ArbolBin<T> arbol){
        boolean res = true;
        if(arbol.izq.raiz != null && arbol.der.raiz != null){
            res &= espejo(arbol.izq, arbol.der);
        }
        if(arbol.izq.raiz == null && arbol.der.raiz != null){
            res = false;
        }
        if(arbol.izq.raiz != null && arbol.der.raiz == null){
            res = false;
        }
        return res;
    }
    
    private boolean espejo(ArbolBin<T> arbol1, ArbolBin<T> arbol2){
        boolean aux = true;
        if(arbol1.raiz != arbol2.raiz) return false;
        if(arbol1.izq.raiz != null && arbol2.der.raiz != null) aux &= espejo(arbol1.izq, arbol2.der);
        if(arbol1.der.raiz != null && arbol2.izq.raiz != null) aux &= espejo(arbol1.der, arbol2.izq);
        return aux;
    }
    
    public void insertarLista(T[] ar){
        int tam = ar.length;
        for(int i = 0; i < tam; i++){
            this.insertar(ar[i]);
        }
    }
    
    public T LCA(ArbolBin<T> arbol, T nodoa, T nodob) {
        if (arbol == null || arbol.raiz == null) {
            return null;
        }
        if (arbol.raiz.equals(nodoa) || arbol.raiz.equals(nodob)) {
            return arbol.raiz;
        }
    
        T izq = LCA(arbol.izq, nodoa, nodob);
        T der = LCA(arbol.der, nodoa, nodob);
    
        if (izq != null && der != null) {
            return arbol.raiz;
        }
        
        if (izq != null) {
            return izq;
        } else {
            return der;
        }
    }

    public void podar(int n){
        if(!vacia()){
            podar(n,1);
        }
    }
    
    private void podar(int n, int altura){
        if(!vacia()){
            if(altura == n){
                izq = new ArbolBin();
                der = new ArbolBin();
            }else{
                izq.podar(n, altura+1);
                der.podar(n, altura+1);
            }
        }
    }
    
    public T padreIterando(T dato){
        T res = null;
        Pila<ArbolBin<T>> pila = new Pila<>();
        pila.push(this);
        while(!pila.vacia()){
            ArbolBin<T> act = pila.pop();
            if((act.izq.raiz != null && act.izq.raiz.equals(dato)) || (act.der.raiz!=null && act.der.raiz.equals(dato))){
                res = act.raiz;
            }else{//sino añada los arboles hijos a la pila
                if(!act.der.vacia()){
                    pila.push(act.der);
                }
                if(!act.izq.vacia()){
                    pila.push(act.izq);
                }
            }
        }
        return res;
    }
    
    private T padre(T dato){
        return padre(dato,null);
    }
    
    public T padre(T dato, T padre){
        T res;
        if(vacia()){
            res= null;
        }else{
            if(raiz.equals(dato)){
                res = padre;
            }else{
                res = izq.padre(dato, raiz);
                if(res == null){
                    res = der.padre(dato, raiz);
                }
            }
        }
        return res;
    }
    
    public boolean contieneIterativo(T dato){
        boolean res = false;
        if(!vacia()){
            Pila<ArbolBin<T>> pila = new Pila<>();
            pila.push(this);
            while(!pila.vacia() && !res){
                ArbolBin<T> act = pila.pop();
                if(!act.vacia() && act.raiz.equals(dato)){
                    res = true;
                }else{
                    pila.push(der);
                    pila.push(izq);
                }
            }
        }
        return res;
    }
    
    public boolean contiene(T dato){
        boolean res; 
        if(vacia()){
            res = false;
        }else{
            if(raiz.equals(dato)){
                res = true;
            }else{
                res = izq.contiene(dato);
                if(!res){ //res == false
                    res = der.contiene(dato);
                }
            }
        }
        return res;
    }
}












