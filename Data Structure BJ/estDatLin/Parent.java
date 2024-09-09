package estDatLin;
/**
 2.- (4 puntos) Dada una cadena formada por paréntesis de apertura y cierre, hallar la longitud
de la subcadena de paréntesis válida más larga. El método principal deberá tener la siguiente
firma: parentesisValido(String cad): int
Ejemplo1: Si se proporciona la cadena ((() la respuesta será 2. Ya que la subcadena más larga
que se puede formar es ().
Ejemplo2: Si se proporciona la cadena ()(())))) la respuesta será 6. Ya que la subcadena más larga
que se puede formar es ()(()).
Debes usar la o las estructuras de datos que mejor se adapten al problema.

 */
public class Parent
{
    public int parentesisValido(String cad){ // ( ) ( ( ) ) ) ) ) 6 validos
        //                                      0 1 2 3 4 5 6 7 8
        int tam = cad.length(); 
        Pila<Character> pila = new Pila<Character>();
        int contador = 0;
        for (int i = 0; i < tam; i++) {
            char ch = cad.charAt(i);
            // parentesis de apertura
            if (ch == '(') {
                pila.push('(');
            } else {
                //parentesis de cierre
                if (pila.vacia()) {
                    break; // Sale del bucle
                } else {
                    char par = pila.pop(); // Desapila el tope por (
                    contador = contador + 2;
                }
            }
        }
        return contador; // Devuelve el resultado del balanceo
    }  
}










































































