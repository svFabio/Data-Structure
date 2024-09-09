package estDatNoLin;
public class Fibo
{
    public ArbolBin<Integer> trazaEjecucion(int n){
        ArbolBin<Integer> res;
        if(n <= 2){
            //nuevo arbolBin con raiz n
            res = new ArbolBin<>(n);
        }else{
            res = new ArbolBin<>(n,trazaEjecucion(n-1),trazaEjecucion(n-2));
        }
        return res;
    }
}
