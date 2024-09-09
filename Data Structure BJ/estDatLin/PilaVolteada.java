package estDatLin;
/**Clase que implementa una pila que puede devolver el mínimo elemento en tiempo constante.
 */
public class PilaVolteada{
    /// solo colocar la pila actual en otra pila y esa seria la pila volteada
    public Pila<Integer> pilaVolt(Pila<Integer> pila){
        Pila<Integer> pilaVolteada = new Pila <Integer>();
        while(pila.tope() != null){ 
            pilaVolteada.push(pila.pop());        
        }
        return pilaVolteada;
    }
}



































    
