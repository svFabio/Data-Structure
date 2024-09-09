package estDatNoLin;
public class ArbolTRIB<T extends Comparable<T>>{
    private T raiz;
    private ArbolTRIB<T> izq, med, der;
    
    public ArbolTRIB(){
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
            izq = new ArbolTRIB<T>();
            der = new ArbolTRIB<T>();
            med = new ArbolTRIB<T>();
        }else{
            if(dato.compareTo(raiz) < 0){
                izq.insertar(dato);
            }else{
                if(dato.compareTo(raiz) > 0){
                    der.insertar(dato);
                }else{
                    med.insertar(dato);
                }
            }
        }
    }
    
    public int repetidos(){
        int ans = 0;
        if(!med.esVacia()) ans++;
        if(!izq.esVacia()) ans += izq.repetidos();
        if(!der.esVacia()) ans += der.repetidos();
        return ans;
    }
    
    public void entradaFast(T ar[]){
        int tam = ar.length;
        for(int i = 0; i < tam; i++){
            insertar(ar[i]);
        }
    }
}

