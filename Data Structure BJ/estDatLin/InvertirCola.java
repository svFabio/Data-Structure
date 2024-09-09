package estDatLin;
public class InvertirCola
{
    public Cola<String> invertir(Cola <String> cola){
        Cola<String> res = new Cola<>();
        Cola<String> aux = new Cola<>();
        Pila<String> pila = new Pila<>();
        
        while(!cola.vacia()){
            String act = cola.decolar();
            res.encolar(act);
            pila.push(act);
        }
        while(!pila.vacia()){
            res.encolar(pila.pop());
            cola.encolar(aux.decolar());
        }
        // reconstruyendo la cola destruida
        return res;
    }
}
