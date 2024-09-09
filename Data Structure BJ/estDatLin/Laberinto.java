package estDatLin;
public class Laberinto {
    
    public int distanciaMinima(char[][] laberinto, int i, int j) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;
        // si Nico spawnea en una pared 
        if (laberinto[i][j] == 'P') {
            return -1; 
        }

        boolean[][] visitado = new boolean[filas][columnas];
        Cola<Posicion> cola = new Cola<Posicion>();
        cola.encolar(new Posicion(i+1, j+1, 0));
        visitado[i][j] = true;

        int[] movX = {-1, 1, 0, 0}; 
        //arriba, abajo, izquierda, derecha
        int[] movY = {0, 0, -1, 1};

        while (!cola.vacia()) {
            Posicion actual = cola.decolar();
            int x = actual.x;
            int y = actual.y;
            int distancia = actual.distancia;
            
            
            // es una salida borde del laberinto
            if (x == 0 || x == filas - 1 || y == 0 || y == columnas - 1) {
                return distancia;
            }

            
            for (int k = 0; k < 4; k++) { //explo cuatro direcciones
                int nuevoX = x + movX[k];
                int nuevoY = y + movY[k];

                if (esValido(nuevoX, nuevoY, filas, columnas) && laberinto[nuevoX][nuevoY] == 'V' && !visitado[nuevoX][nuevoY]){
                    cola.encolar(new Posicion(nuevoX, nuevoY, distancia + 1));
                    visitado[nuevoX][nuevoY] = true;
                }
            }
        }

        return -1; 
        //no hubo salida
    }

    private boolean esValido(int x, int y, int filas, int columnas) {
        return x >= 0 && x < filas &&y >= 0 && y < columnas;
    }
    
    
    //prueba
    //(2,2) es (1,1) porque inicie en 0 mis filas y columnas
    public int Prueba() {
        char[][] laberinto = {
            
            {'P','P','P','P','P','P','P','P','P','P','P'},
            {'P','V','V','V','P','V','V','V','V','V','P'},
            {'P','V','P','V','P','V','P','P','P','V','P'},  
            {'P','V','P','V','V','V','V','P','P','V','P'},
            {'P','V','P','P','P','P','V','P','P','V','P'},
            {'P','V','V','V','V','P','V','P','P','V','P'}
        };
        
        //ejemplo del probelma (1,1) 
        int distancia = distanciaMinima(laberinto, 1, 1);
        return distancia;
    }  
}

