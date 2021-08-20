public class Mapa {
    
    Nodo[][] matrizMapa;
    Punto posicion;

    public Mapa(int x, int y){
        matrizMapa = new Nodo[10][10];
        posicion = new Punto(x, y);
        crearMapa();
        matrizMapa[x][y].setEstanciaPlayer(true);
    }

    public void crearMapa(){
        for(int x = 0; x < matrizMapa.length; x++){
            for(int y = 0; y < matrizMapa[x].length; y++){
                matrizMapa[x][y] = new Nodo(x, y);
            }
        }
    }

    public void imprimirMapa(){
        for(int x = 0; x < matrizMapa.length; x++){
            for(int y = 0; y < matrizMapa[x].length; y++){
                matrizMapa[x][y].imprimirNodo();
            }
            System.out.println();
        }
    }

    public Nodo getNodoActual(){
        int x = posicion.getX();
        int y = posicion.getY();
        return matrizMapa[x][y];
    }

    public void setPosicion(int x, int y){
        posicion.setX(x);
        posicion.setY(y);
    }

}
