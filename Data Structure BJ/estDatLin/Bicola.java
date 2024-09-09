package estDatLin;
public class Bicola<T> extends Cola<T>{
    public void encolarAdelante(T dato){
        NodoDE<T> p;
        p = new NodoDE<T>(dato);
        if(vacia()){
            frente = fin = p;
        }else{
            p.setSuc(frente);
            frente.setAnt(p);
            frente = p;
        }
    }
    
    public T desencolarAtras(){
        T dato;
        if(vacia()){
            dato = null;
        }else{
            dato = fin.getDato();
            fin = fin.getAnt();
            if(fin == null){
                frente = null;
            }else{
                fin.setSuc(null);
            }
        }
        return dato;
    }
}
