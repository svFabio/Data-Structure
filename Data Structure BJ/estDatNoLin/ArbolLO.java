package estDatNoLin;
public class ArbolLO < T extends Comparable<T>>{
    private T raiz;
    private ArbolLO<T> izq, der;
    
    public ArbolLO(){
        raiz = null;
        izq = null;
        der = null;
   } 
   public boolean vacia(){
        return raiz == null;
    }
   public ArbolLO(T dato){
        if(dato!=null){
            raiz = dato;
            izq = new ArbolLO();
            der = new ArbolLO();
        }else{
            raiz = null;
            izq = null;
            der = null;
        }
   }
   
   private void intercambio(ArbolLO<T> a, T dato){
       T aux = a.raiz;
       T auxIzq = a.izq.raiz;
       T auxDer = a.der.raiz;
       
       a.raiz = dato;
       a.izq.raiz = aux;
       a.der = new ArbolLO<T>();
       a.izq.izq = new ArbolLO<T>(auxIzq);
       a.izq.der = new ArbolLO<T>(auxDer);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
