package estDatLin;

public class Set<T>
{
    private class NodoDE<T>{
        T dato;
        NodoDE<T> suc, ant;
        
        public NodoDE(T dato){
            this.dato = dato;
            suc = ant = null;
        }
    }
    private NodoDE<T> ini;
        
    public Set(){
        ini = null;
    }
    public boolean esVacia(){
        return ini == null;
    }
    private NodoDE<T> buscar (NodoDE<T> aux, T dato){
        NodoDE<T> res;
        if(aux.suc == null || aux.dato.equals(dato)){
            res = aux;
        }else{
            res = buscar(aux.suc, dato);
        }
        return res;
    }
    public void insertar(T dato){
        NodoDE<T> p = new NodoDE<>(dato);
        if(esVacia()){
            ini = p;
        }else{
            NodoDE<T> q = buscar(ini, dato);
            if(q.dato.equals(dato)){
                q.dato = dato; //q.setDato(dato)
            }else{
                q.suc = p;
                p.ant = q;
            }
        }
    }
}
