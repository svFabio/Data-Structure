package estDatLin;
/*** Clase que representa un par de elementos comparables.
 * @param <T> El tipo de los elementos del par, que deben ser comparables.
 */
public class Par<T extends Comparable<T>> implements Comparable<Par<T>> {
    private T first; // Primer elemento del par
    private T second; // Segundo elemento del par

    /**
     * Constructor por defecto que inicializa ambos elementos a null.
     */
    public Par() {
        first = null;
        second = null;
    }

    /**
     * Constructor que inicializa el par con dos elementos dados.
     * @param first El primer elemento del par.
     * @param second El segundo elemento del par.
     */
    public Par(T first, T second) {
        this.first = first;
        this.second = second;
    }

    // Métodos getter y setter para acceder y modificar los elementos del par

    /**
     * Obtiene el primer elemento del par.
     * @return El primer elemento del par.
     */
    public T getFirst() {
        return first;
    }

    /**
     * Obtiene el segundo elemento del par.
     * @return El segundo elemento del par.
     */
    public T getSecond() {
        return second;
    }

    /**
     * Establece el primer elemento del par.
     * @param f El primer elemento del par.
     */
    public void setFirst(T f) {
        first = f;
    }

    /**
     * Establece el segundo elemento del par.
     * @param s El segundo elemento del par.
     */
    public void setSecond(T s) {
        second = s;
    }

    /**
     * Compara este par con otro par dado.
     * @param otroPar El otro par con el que se compara.
     * @return Un valor negativo si este par es menor que el otro par,
     *         cero si son iguales y un valor positivo si este par es mayor que el otro par.
     */
    @Override
    public int compareTo(Par<T> otroPar) {
        // Compara el primer elemento de este par con el primer elemento del otro par
        int comparacion = first.compareTo(otroPar.getFirst());
        if (comparacion == 0) { // Si los primeros elementos son iguales, compara los segundos elementos
            return second.compareTo(otroPar.getSecond());
        }
        return comparacion; // Devuelve el resultado de la comparación de los primeros elementos
    }
}
