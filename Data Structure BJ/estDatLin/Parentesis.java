package estDatLin;
import java.util.*;
/*** Clase Parentesis que proporciona una funcionalidad para verificar el balance de par�ntesis en una cadena.*/
public class Parentesis {
    /** * M�todo que verifica si los par�ntesis en una cadena est�n balanceados.
     * @param cad La cadena de entrada que contiene los par�ntesis.
     * @return true si los par�ntesis est�n balanceados, false en caso contrario.*/
    public boolean balanceado(String cad) {
        int tam = cad.length(); // Obtiene el tama�o de la cadena de entrada
        Pila<Character> pila = new Pila<Character>(); // Inicializa una pila para almacenar los par�ntesis
        boolean bo = true; // Variable para indicar si la cadena est� balanceada
        // Recorre cada car�cter de la cadena de entrada
        int contador = 0;
        for (int i = 0; i < tam; i++) {
            char ch = cad.charAt(i); // Obtiene el car�cter actual
            
            // Si el car�cter es un par�ntesis de apertura, lo apila
            if (ch == '(') {
                pila.push('(');
            } else {
                // Si el car�cter es un par�ntesis de cierre
                // Verifica si la pila est� vac�a (desbalanceado) o desapila el tope
                if (pila.vacia()) {
                    bo = false; // Marca como desbalanceado
                    break; // Sale del bucle
                } else {
                    char par = pila.pop(); // Desapila el tope (par�ntesis de apertura)
                       
                }
            }
        }
        // Si la pila no est� vac�a despu�s de recorrer la cadena, los par�ntesis no est�n balanceados
        if (!pila.vacia()) bo = false;
        return bo; // Devuelve el resultado del balanceo
    }
}























