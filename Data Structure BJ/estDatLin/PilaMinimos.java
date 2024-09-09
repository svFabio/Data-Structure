package estDatLin;
/**Clase que implementa una pila que puede devolver el mínimo elemento en tiempo constante.
 */
public class PilaMinimos{
    // Pila que almacena pares de enteros.
    private Pila<Par<Integer>> pila;
    // Constructor que inicializa la pila.
    public PilaMinimos(){
        pila = new Pila<Par<Integer>>();
    }
    
    /**
     * Método para agregar un elemento a la pila.
     * @param dato El dato a agregar.
     */
    public void push(int dato){
        // Crear un nuevo par para almacenar el dato y el mínimo.
        Par par = new Par();
        par.setFirst(dato);
        
        // Si la pila está vacía, el mínimo es el mismo dato.
        if(pila.vacia()){
            par.setSecond(dato);
        } else {
            // Si la pila no está vacía, obtener el mínimo actual de la pila.
            Par<Integer> topi = pila.tope();
            int minow = topi.getSecond();
            
            // Comparar el dato con el mínimo actual y actualizar el mínimo en el nuevo par.
            if(minow <= dato){
                par.setSecond(minow);
            } else {
                par.setSecond(dato);
            }
        }
        
        // Agregar el nuevo par a la pila.
        pila.push(par);
    }
    
    /*** Método para eliminar y devolver el elemento en la cima de la pila.
     * @return El par que se encuentra en la cima de la pila.*/
    public Par<Integer> pop(){
        Par<Integer> par = pila.pop();
        return par;
    }
    
    /**Método para obtener el elemento en la cima de la pila sin eliminarlo.
     * return El primer elemento del par en la cima de la pila.*/
    public int getTope(){
        return pila.tope().getFirst();
    }
    
    /**Método para obtener el mínimo elemento de la pila.
     * @return El segundo elemento del par en la cima de la pila, que es el mínimo.*/
    public int getMinimo(){
        return pila.tope().getSecond();
    }
}
