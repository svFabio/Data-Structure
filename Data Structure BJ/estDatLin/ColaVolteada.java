package estDatLin;
/*** Clase que proporciona una operación para voltear los primeros k elementos de una cola.
 */
public class ColaVolteada{
    /*** Método que voltea los primeros k elementos de una cola.*/
    public Cola<Integer> colavolteada(Cola<Integer> cola, int k, int n){
        Pila<Integer> pila = new Pila<Integer>();
        // Extraer los primeros k elementos de la cola y empujarlos a la pila.
        for(int i = 0; i < k; i++){
            int popeado = cola.decolar();
            pila.push(popeado);
        }
        // Sacar los elementos de la pila y volver a encolarlos en la cola,
        // lo que efectivamente voltea los primeros k elementos.
        while(!pila.vacia()){
            int popeado = pila.pop();
            cola.encolar(popeado);
        }
        // Mover los elementos restantes de la cola (n - k) al final de la cola,
        // para mantener el orden original de estos elementos.
        for(int i = 0; i < n - k; i++){
            int decolado = cola.decolar();
            cola.encolar(decolado);
        }
        return cola;
    }
}








