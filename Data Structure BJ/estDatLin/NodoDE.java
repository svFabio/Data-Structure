package estDatLin;
public class NodoDE<T>
{
    // los nodos tienen DATOS Y ENLACES
    private NodoDE<T> ant;
    private T         dato;
    private NodoDE<T> suc;
    
    public NodoDE(T dato){
        this.dato = dato;
        ant = null;
        suc = null;
    }
    
    public NodoDE(){
        this.dato = null;
        ant = null;
        suc = null;
    }
    
    public void setSuc(NodoDE<T> s){
        suc = s;
    }
    
    public void setAnt(NodoDE<T> a){
        ant = a;
    }

    public void setDato(T d){
        dato = d;
    }
    
    public NodoDE<T> getAnt(){
        return ant;
    }
    
    public NodoDE<T> getSuc(){
        return suc;
    }
    
    public T getDato(){
        return dato;
    }
    
    public boolean nodoVacio(){
        return dato == null;
    }    
}
