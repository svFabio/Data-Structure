package estDatNoLin;
import estDatLin.*;
import java.util.*;

/**
 * Write a description of class ArbolBB here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArbolBB<T extends Comparable<T>>
{
    private ArbolBB<T> izq;
    private T          raiz;
    private ArbolBB<T> der;
    
    public ArbolBB(){
        raiz = null;
        izq = null;
        der = null;
    }
    
    public boolean esVacia(){
        return raiz == null;
    }
    
    public void insertar(T dato){
        if(esVacia()){
            raiz = dato;
            izq = new ArbolBB<T>();
            der = new ArbolBB<T>();
        }else{
            if(dato.compareTo(raiz) < 0){
                izq.insertar(dato);
            }else{
                der.insertar(dato);
            }
        }
    }
    
    public T eliminar(T dato){
        T elDato;
        int estado;
        ArbolBB<T> sustituto;
        if(esVacia()){
            elDato = null;
        }else{
            if(dato.compareTo(raiz) < 0){
                elDato = izq.eliminar(dato);
            }else{
                if(dato.compareTo(raiz) > 0){
                    elDato = der.eliminar(dato);
                }else{
                    elDato = raiz;
                    estado = estadoRaiz();
                    switch(estado){
                        case 0: // raiz es hoja
                                raiz = null;
                                izq = null;
                                der = null;
                                break;
                        case 1: // raiz tiene desc izq no vacia der es vacia
                                raiz = izq.raiz;
                                der  = izq.der;
                                izq  = izq.izq;
                                break;
                        case 2: // raiz tiene desc izq no vacia y der vacia
                                raiz = der.raiz;
                                izq  = der.izq;
                                der  = der.der;
                                break;
                        case 3: // taiz tiene desc izq y der no vacias
                                sustituto = der.descIzq();
                                raiz = sustituto.raiz;
                                sustituto.eliminar(raiz);
                    }
                }
            }
        }
        return elDato;
    }
    
    private int estadoRaiz(){
        int estado;
        if(izq.esVacia()){
            if(der.esVacia()){
                estado = 0;
            }else{
                estado = 2;
            }
        }else{
            if(der.esVacia()){
                estado = 1;
            }else{
                estado = 3;
            }
        }
        return estado;
    }
    
    private ArbolBB<T> descIzq(){
        ArbolBB<T> sustituto;
        if(izq.esVacia()){
            sustituto = this;
        }else{
            sustituto = izq.descIzq();
        }
        return sustituto;
    }
    
    public int internosVerdaderos() {
        if (raiz == null) {
            return 0; 
        }
        Cola<ArbolBB<T>> cola = new Cola<ArbolBB<T>>();
        cola.encolar(this);
        int bordes = 0, nextlevel = 1;
        while (!cola.vacia()) {
            int nodosEnNivel = nextlevel;
            nextlevel = 0;
            boolean esPrimerNodo = true;
            while (nodosEnNivel > 0) {
                ArbolBB<T> arbolAct = cola.decolar();
                nodosEnNivel--;
                boolean esHoja = true; 
                if (arbolAct.izq.raiz != null) {
                    cola.encolar(arbolAct.izq);
                    nextlevel++;
                    esHoja = false;
                }
                if (arbolAct.der.raiz != null) {
                    cola.encolar(arbolAct.der);
                    nextlevel++;
                    esHoja = false; 
                }
                if (esPrimerNodo || nodosEnNivel == 0) {
                    bordes++;
                    esPrimerNodo = false;
                }else{
                    if(esHoja) bordes++;
                }
            }
        }
        int totalNodos = contarDatos();
        int internosVerdaderos = totalNodos - bordes;
        return internosVerdaderos;
    }
    
    public int contarDatos(){
        int ans = 0;
        if(raiz != null) ans++;
        if(izq.raiz != null) ans += izq.contarDatos();
        if(der.raiz != null) ans += der.contarDatos();
        return ans;
    }
    
    public void entradaFast(T ar[]){
        int tam = ar.length;
        for(int i = 0; i < tam; i++){
            insertar(ar[i]);
        }
    }
    
    public ListaSE<T> ruta(ArbolBB<T> arbol, T dato){
        ListaSE<T> lista = new ListaSE<T>();
        if(arbol.raiz == null) return lista;
        if(arbol.raiz == dato){
            lista.insertar(arbol.raiz);
            return lista;
        }
        ListaSE<T> lista1 = ruta(arbol.izq, dato);
        if(lista1.longitud() >0){
            //lista1.add(0, arbol.raiz);
            lista1.insertar(arbol.raiz, 0);
            return lista1;
        }else{
            ListaSE<T> lista2 = ruta(arbol.der, dato);
            if(lista2.longitud()>0){
                lista2.insertar(arbol.raiz, 0);
                return lista2;
            }
        }
        return lista;
    }
    
    public boolean parcialmente(ArbolBB<T> arbol){
        Cola<ArbolBB<T>> cola = new Cola<ArbolBB<T>>();
        cola.encolar(arbol);
        boolean res = true, boaux = true;
        while(!cola.vacia()){
            ArbolBB<T> arbolTope = cola.decolar();
            if(arbolTope.raiz == null){
                boaux = false;
            }else{
                if(!boaux){
                    res = false;
                }
                cola.encolar(arbolTope.izq);
                cola.encolar(arbolTope.der);
            }
        }
        return res;
    }
    
     public boolean samefringe(ArbolBB<T> arbol1, ArbolBB<T> arbol2){
        ArrayList<T> lista1 = new ArrayList<T>();
        ArrayList<T> lista2 = new ArrayList<T>();
        ordenHojas(arbol1, lista1);
        ordenHojas(arbol2, lista2);
        int tam1 = lista1.size(), tam2 = lista2.size();
        boolean res = true;
        if(tam1 == tam2){
            for(int i = 0; i < tam1; i++){
                if(lista1.get(i) != lista2.get(i)) res = false;
            }
        }
        return res;
    }
    
     private void ordenHojas(ArbolBB<T> arbol, ArrayList<T> lista){
        if(arbol.raiz != null){
            if(arbol.izq.raiz == null && arbol.der.raiz == null){
                lista.add(arbol.raiz);
                return;
            }
            ordenHojas(arbol.izq, lista);
            ordenHojas(arbol.der, lista);
        }
    }
    
     public boolean espejo(ArbolBB<T> arbol){
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
    
    private boolean espejo(ArbolBB<T> arbol1, ArbolBB<T> arbol2){
        boolean aux = true;
        if(arbol1.raiz != arbol2.raiz) return false;
        if(arbol1.izq.raiz != null && arbol2.der.raiz != null) aux &= espejo(arbol1.izq, arbol2.der);
        if(arbol1.der.raiz != null && arbol2.izq.raiz != null) aux &= espejo(arbol1.der, arbol2.izq);
        return aux;
    }
}

