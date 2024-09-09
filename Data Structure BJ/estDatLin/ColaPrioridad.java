package estDatLin;
public class ColaPrioridad<T extends Comparable<T>> extends Cola<T>{
    public void encolar(T dato){
        NodoDE<T> nuevo;
        nuevo = new NodoDE<T>(dato);
        if(vacia()){
            frente = fin = nuevo;
        }else{
            NodoDE<T> actual = fin;
            while(actual != null && actual.getDato().compareTo(dato)>0){
                actual = actual.getAnt();
            }
            if(actual == null){
                nuevo.setSuc(frente);
                frente.setAnt(nuevo);
                frente = nuevo;
            }else{
                if(actual != fin){
                    NodoDE<T> sucactual = actual.getSuc();
                    nuevo.setSuc(sucactual);
                    sucactual.setAnt(nuevo);
                }
                actual.setSuc(nuevo);
                nuevo.setAnt(actual);
                if(actual == fin){
                    fin = nuevo;
                }
            }
        }
    }
}















