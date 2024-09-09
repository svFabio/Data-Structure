package estDatLin;

import java.util.*;
public class Pila<T> implements Coleccion<T>{
    T tope;
    Pila<T> base;
    
    public Pila(){
        tope = null;
        base = null;
    }
    
    public Pila(T tope, Pila<T> base){
        this.tope = tope;
        this.base = base;
    }
    
    //La pila tiene las operaciones: Vacia, push, pop, tope
    public boolean vacia(){
        return tope == null;
    }
    
    public void push(T dato){
        if(vacia()){
            tope = dato;
            base = new Pila<T>();
        }else{
            base = new Pila<T>(tope, base);
            tope = dato;
        }
    }
    public T pop(){
        T dato = null;
        if(!vacia()){
            dato = tope;
            tope = base.tope;
            base = base.base;
        }
        return dato;
    }
    public T tope(){
        return tope;
    }
}
