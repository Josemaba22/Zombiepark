import java.io.IOException;

public class Main {

    public static void main(String[] arg) throws InterruptedException, IOException{
        
        Mapa mapa = new Mapa(5, 5);
        Player player = new Player("El SoS");
        new Control(mapa, player);

    }
    
}
