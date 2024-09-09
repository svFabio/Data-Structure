package estDatLin;
import java.util.*;
/**
 * Clase MenorCercano que proporciona una funcionalidad para encontrar el menor elemento cercano en un array.*/
public class MenorCercano {
    /*** Método que encuentra el menor elemento cercano a cada elemento en un array.
     *
     * @param ar El array de entrada.
     * @return Un array de enteros donde cada posición i contiene el menor elemento
     *         a la izquierda de ar[i] que es menor que ar[i], o 0 si no hay tal elemento.*/
    public int[] menorCercano(int[] ar) {
        int tam = ar.length; // Obtiene el tamaño del array de entrada
        Pila<Integer> pila = new Pila<Integer>(); // Inicializa una pila para almacenar los elementos del array
        int[] ans = new int[tam]; // Array de respuesta para almacenar los menores cercanos
        // Recorrer el array de entrada
        for (int i = 0; i < tam; i++) {
            int num = ar[i]; // Elemento actual del array
            // Desapilar elementos mayores o iguales al elemento actual
            while (!pila.vacia() && num <= pila.tope()) {
                int popeado = pila.pop(); // Desapila el elemento del tope
            }
            // Si la pila está vacía, no hay menor cercano, poner 0
            if (pila.vacia()) {
                ans[i] = 0; // Asigna 0 en la posición correspondiente del array de respuesta
            } else {
                // Si la pila no está vacía, el tope es el menor cercano
                ans[i] = pila.tope(); // Asigna el tope de la pila a la posición correspondiente del array de respuesta
            }
            // Empujar el elemento actual a la pila
            pila.push(num); // Apila el elemento actual
        }
        return ans; // Devuelve el array de menores cercanos
    }
}

