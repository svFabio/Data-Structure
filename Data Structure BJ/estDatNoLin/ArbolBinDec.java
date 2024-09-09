package estDatNoLin;
import estDatLin.*;
import java.util.*;

public class ArbolBinDec<T>{
    private ArbolBinDec<T> izq;
    private T           raiz;
    private ArbolBinDec<T> der;
    public ArbolBinDec(){
        izq = null;
        raiz = null;
        der = null;
    }
    
    public ArbolBinDec(T raiz, ArbolBinDec<T> izq, ArbolBinDec<T> der){
        this.izq = izq;
        this.raiz = raiz;
        this.der = der;
    }
    
    public ArbolBinDec(T raiz){
        izq = null;
        this.raiz = raiz;
        der = null;
    }
    
    public void insertar(T dato, String camino[]){
        insertar(dato, camino, 0);
    }
    
    private void insertar(T dato, String camino[], int pos){
        if(pos == camino.length){
            if(raiz == null){
                raiz = dato;
                izq = new ArbolBinDec();
                der = new ArbolBinDec();
            }
        }else{
            if(raiz != null){
                if(camino[pos] == "si"){
                    izq.insertar(dato, camino, pos+1);
                }else{
                    der.insertar(dato, camino, pos+1);
                }
            }
        }
    }
    
    public boolean eliminar(T dato){
        boolean seElimino;
        if(raiz == null){
            seElimino = false;
        }else{
            if(dato.equals(raiz)){
                if(izq.raiz == null && der.raiz == null){
                    raiz = null;
                    izq = null;
                    der = null;
                    seElimino = true;
                }else{
                    seElimino = izq.eliminar(dato);
                    if(!seElimino){
                        seElimino = der.eliminar(dato);
                    }
                }
            }else{
                seElimino = izq.eliminar(dato);
                if(!seElimino){
                    seElimino = der.eliminar(dato);
                }
            }
        }
        return seElimino;
    }
    
    public T decisionFinal(String camino[]){
        T ans = decisionFinal(camino, 0);
        return ans;
    }
    
    private T decisionFinal(String camino[], int pos){
        if(raiz == null) return null;
        if(pos >= camino.length){
            return raiz;
        }  
        if(camino[pos] == "si"){
            if(izq.raiz != null){
                return izq.decisionFinal(camino, pos+1);
            }else return null;
        }else{
            if(der.raiz != null){
                return der.decisionFinal(camino, pos+1);
            }else return null;
        }
    }
}
