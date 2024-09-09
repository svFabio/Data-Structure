package estDatNoLin;
import estDatLin.*;
import java.util.*;

public class Tren{
    NodoDE<Integer> locomotora;
    NodoDE<Integer> ultimo;
    
    public Tren(){
        locomotora = null;
        ultimo = null;
    }
    
    public void agregarVagon(int id){
        NodoDE<Integer> nuevoVagon = new NodoDE<Integer>(id);
        if(locomotora == null){
            locomotora = nuevoVagon;
            ultimo = nuevoVagon;
        }else{
            ultimo.setSuc(nuevoVagon);
            nuevoVagon.setAnt(ultimo);
            ultimo = nuevoVagon;
        }
    }
    
    public void desengancharVagon(int id){
        NodoDE<Integer> vagonAct = locomotora;
        
        if(ultimo != null && ultimo.getDato() == id){
            if(ultimo.getAnt() != null){
                ultimo.getAnt().setSuc(null);
            }else{
                locomotora = null;
            }
            ultimo = ultimo.getAnt();
            return;
        }
        
        while(vagonAct != null && vagonAct.getDato() != id){
            vagonAct = vagonAct.getSuc();
        }
        if(vagonAct == null){
            System.out.println("El vagon no existe");
            return;
        }
        if(vagonAct.getAnt() != null){
            vagonAct.getAnt().setSuc(vagonAct.getSuc());
        }else{
            locomotora = vagonAct.getSuc();
        }
        
        if(vagonAct.getSuc() != null){
            vagonAct.getSuc().setAnt(vagonAct.getAnt());
        }else{
            ultimo = vagonAct.getAnt();
        }
    }
}
