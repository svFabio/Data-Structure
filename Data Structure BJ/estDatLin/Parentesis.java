package estDatLin;
import java.util.*;
/*** Clase Parentesis que proporciona una funcionalidad para verificar el balance de paréntesis en una cadena.*/
public class Parentesis {
    /** * Método que verifica si los paréntesis en una cadena están balanceados.
     * @param cad La cadena de entrada que contiene los paréntesis.
     * @return true si los paréntesis están balanceados, false en caso contrario.*/
    public boolean balanceado(String cad) {
        int tam = cad.length(); // Obtiene el tamaño de la cadena de entrada
        Pila<Character> pila = new Pila<Character>(); // Inicializa una pila para almacenar los paréntesis
        boolean bo = true; // Variable para indicar si la cadena está balanceada
        // Recorre cada carácter de la cadena de entrada
        int contador = 0;
        for (int i = 0; i < tam; i++) {
            char ch = cad.charAt(i); // Obtiene el carácter actual
            
            // Si el carácter es un paréntesis de apertura, lo apila
            if (ch == '(') {
                pila.push('(');
            } else {
                // Si el carácter es un paréntesis de cierre
                // Verifica si la pila está vacía (desbalanceado) o desapila el tope
                if (pila.vacia()) {
                    bo = false; // Marca como desbalanceado
                    break; // Sale del bucle
                } else {
                    char par = pila.pop(); // Desapila el tope (paréntesis de apertura)
                       
                }
            }
        }
        // Si la pila no está vacía después de recorrer la cadena, los paréntesis no están balanceados
        if (!pila.vacia()) bo = false;
        return bo; // Devuelve el resultado del balanceo
    }
}























