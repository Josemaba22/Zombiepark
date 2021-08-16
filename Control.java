import java.io.IOException;

public class Control {

    Mapa mapa;
    Player player;

    public Control(Mapa mapa, Player player) throws InterruptedException, IOException{
        
        limpiarPantalla();
        this.mapa = mapa;
        this.player = player;
        mapa.imprimirMapa();
        acciones();
        
    }
    
    public void ataqueZombie(){
        
        if(mapa.getNodoActual().invacionZombie()){
            System.out.println("ALERTA: Los Zombies te atacan!!!");
        }

    }
    
    public void acciones() throws InterruptedException, IOException{
        
        System.out.println(
            "\n---------------"+
            "\nACCIONES"+
            "\n---------------"+
            "\n1.-Caminar"+
            "\n2.-info Nodo"+
            "\n3.-Mochila"+
            "\n3.-Escarbar"+
            "\n---------------");
        int opcion = 0;

        do{
            System.out.print("Opción: ");
            opcion = Keyboard.readInt();
            if(opcion < 1 || opcion > 3){
                System.out.println("VALOR INVALIDO!");
            }else break;
        }while(true);

        switch(opcion){
            case 1: caminar();;break;
            case 2: infoNodo();;break;
            default: System.out.println("SAS");
        }

    }
    
    public void limpiarPantalla() throws InterruptedException, IOException{

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("==========================================");
        System.out.println("|               Zombipark                |");
        System.out.println("==========================================\n");
    
    }

    public void caminar() throws InterruptedException, IOException{

        limpiarPantalla();
        mapa.imprimirMapa();
        player.caminar(mapa);  
        mapa.setPunto(player.getX(), player.getY()); 
        limpiarPantalla();
        mapa.imprimirMapa();
        acciones();

    }

    public void infoNodo() throws InterruptedException, IOException{

        limpiarPantalla();
        mapa.imprimirMapa();
        System.out.println(mapa.getNodoActual());
        acciones();

    }
    
}
