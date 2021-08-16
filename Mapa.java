public class Mapa {
    
    Nodo[][] matrizMapa;
    int x;
    int y;

    public Mapa(int x, int y){
        matrizMapa = new Nodo[10][10];
        this.x = x;
        this.y = y;
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
        return matrizMapa[x][y];
    }

    public void setPunto(int x, int y){
        this.x = x;
        this.y = y;
    }

}
