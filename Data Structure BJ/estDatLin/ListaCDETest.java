package estDatLin;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ListaCDETest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaCDETest
{
    /**
     * Default constructor for test class ListaCDETest
     */
    public ListaCDETest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testVacia()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        assertEquals(true, lista.vacia());
    }
    
    @Test
    /**void insertar1(T dato);
     * 
     */
    public void testInsertar1()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        assertEquals(false, lista.vacia());
    }
    
    @Test
    /**void insertar2(T dato, int pos);
     * 
     */
    public void testInsertar2()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v', 10);
        assertEquals(false, lista.vacia());
        lista.insertar('a', 0);
        assertEquals(false, lista.vacia());
        assertEquals(2, lista.longitud());
        
    }
    
    @Test
    /*
     *void eliminar1(int pos); 
     */
    public void testeliminar1()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.eliminar(10);
        assertEquals(true, lista.vacia());
        lista.insertar('v', 0);
        assertEquals(false, lista.vacia());
        assertEquals(1, lista.longitud());
        lista.eliminar(10);
        assertEquals(0, lista.longitud());
        lista.eliminar(0);
        assertEquals(0, lista.longitud());
    }
    /*void eliminar2(T dato);
     * 
     */
    
    public void testeliminar2()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.eliminar('a');
        assertEquals(true, lista.vacia());
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        assertEquals(false, lista.vacia());
        assertEquals(5, lista.longitud());
        lista.eliminar('a');
        assertEquals(4, lista.longitud());
        lista.eliminar('x');
        assertEquals(4, lista.longitud());
    }
    /**
    void eliminar3(int pos1, int pos2);
    elimina los datos desde la pos1 a pos2 inclusive
    {1,2,3,4,5,6,7,8} <-- eliminar 3,14
    {1,2,3}
    {1,2,3,4,5,6,7,8} <-- eliminar 10,14
    {1,2,3,4,5,6,7,8}
    {1,2,3,4,5,6,7,8} <-- eliminar 0,4
    {6,7,8}
    */
    @Test
    public void testeliminar3()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        assertEquals(false, lista.vacia());
        assertEquals(11, lista.longitud());
        lista.eliminar(10, 14);
        assertEquals(6, lista.longitud());
        lista.eliminar(10, 14);
        assertEquals(1, lista.longitud());
        lista.eliminar(1, 4);
        assertEquals(0, lista.longitud());
        
    }
    
    /*
    T acceder1(int pos);
    */
    @Test
    public void testacceder1()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        assertEquals(false, lista.vacia());
        assertEquals(11, lista.longitud());
        assertEquals(new Character('l'), lista.acceder(14));
        assertEquals(new Character('m'), lista.acceder(5));
        assertEquals(new Character('v'), lista.acceder(0));
        
    }
    
    /*
    T acceder2(T dato);
    */
    @Test
    public void testacceder2()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        assertEquals(false, lista.vacia());
        assertEquals(11, lista.longitud());
        assertEquals(null, lista.acceder(new Character('y')));
        assertEquals(new Character('x'),lista.acceder(new Character('x')));
    }
    
    /*
    boolean buscar(T dato);
    */
    @Test
    public void testbuscar()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        assertEquals(false, lista.vacia());
        assertEquals(11, lista.longitud());
        assertEquals(false, lista.buscar(new Character('y')));
        assertEquals(true,lista.buscar(new Character('x')));
    }
    
    /*
    int longitud();
    */
    @Test
    public void testlongitud()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        assertEquals(false, lista.vacia());
        assertEquals(11, lista.longitud());
        lista.eliminar(0);
        assertEquals(10,lista.longitud());
    }
    
    /*
    void vaciar();
    */
    @Test
    public void testvaciar()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        assertEquals(false, lista.vacia());
        assertEquals(11, lista.longitud());
        lista.vaciar();
        assertEquals(0, lista.longitud());
    }
    
    /*
    Lista<T> dividir(T dato);
    {1,2,3,4,5,6,7} dividir 4
    {1,2,3,4} y lista original no cambia
    {1,2,3,4,5,6,7} dividir 10
    {}
    {1,2,3,4,5,6,7} dividir -3
    {}
    */
    @Test
    public void testdividir()
    {
        ListaCDE<Character> lista;
        Lista<Character> listaR;
        lista = new ListaCDE<Character>();
        
        lista.insertar('u');
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l');
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        
        assertEquals(false, lista.vacia());
        assertEquals(12, lista.longitud());
        listaR = lista.dividir(new Character('y'));
        assertEquals(0, listaR.longitud());
        listaR = lista.dividir(new Character('u'));
        assertEquals(1, listaR.longitud());
        listaR = lista.dividir(new Character('x'));
        assertEquals(12,listaR.longitud());
    }
    
    /*
    void reemplazar(T dato, int pos);
    {1,2,3,4,6,7,8} reemplazar 5, 4
    {1,2,3,4,5,7,8}
    {1,2,3,4,5,6,7} reemplaar 7, 10
    {1,2,3,4,5,6,7}
    **/
    @Test
    public void testreemplazar()
    {
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l'); //´y´
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');//'y'
        lista.insertar('u');
        lista.insertar('x');
        
        lista.reemplazar(new Character('y'), 14);
        assertEquals(new Character('y'), lista.acceder(14));
        lista.reemplazar(new Character('y'), 8);
        assertEquals(new Character('y'), lista.acceder(8));
        assertEquals(false, lista.buscar(new Character('t')));
    }
    
    @Test
    public void testdividirMitad(){
        ListaCDE<Character> lista;
        lista = new ListaCDE<Character>();
        Lista<Lista<Character>> listas;
        
        
        lista.insertar('v');
        lista.insertar('u');
        lista.insertar('e');
        lista.insertar('l'); 
        lista.insertar('a');
        lista.insertar('m');
        lista.insertar('i');
        lista.insertar('r');
        lista.insertar('t');
        lista.insertar('u');
        lista.insertar('x');
        
        listas = lista.dividirMitad();
        assertEquals(6, listas.acceder(0).longitud());
        assertEquals(5, listas.acceder(1).longitud());
        assertEquals(11, lista.longitud());
    }
}
