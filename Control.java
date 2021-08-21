import java.io.IOException;

public class Control {

    Mapa mapa;
    Player player;

    public Control(Mapa mapa, Player player) throws InterruptedException, IOException{
        
        this.mapa = mapa;
        limpiarPantalla();
        this.player = player;
        acciones();
        
    }
    
    public void ataqueZombie(){
        
        if(mapa.getNodoActual().invacionZombie()){
            System.out.println("ALERTA: Los Zombies te atacan!!!");
        }

    }
    
    public void acciones() throws InterruptedException, IOException{
        
        System.out.println(
            "\n----------------------"+
            "\nACCIONES"+
            "\n----------------------"+
            "\n1.-Caminar"+
            "\n2.-Info Zona"+
            "\n3.-Inventario"+
            "\n4.-Recoger objeto"+
            "\n5.-Tirar objeto"+
            "\n----------------------");
        int opcion = 0;

        do{
            System.out.print("Opción: ");
            opcion = Keyboard.readInt();
            if(opcion < 1 || opcion > 5){
                System.out.println("VALOR INVALIDO!");
            }else break;
        }while(true);

        switch(opcion){
            case 1: caminar();break;
            case 2: infoNodo();break;
            case 3: inventario();break;
            case 4: recogerObjeto();break;
            case 5: tirarObjeto();break;
            default: System.out.println("SAS");
        }

    }
    
    public void limpiarPantalla() throws InterruptedException, IOException{
        
        // Limpia la pantalla de la consola
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        encabezado();
    
    }

    public void encabezado(){
        
        System.out.println("==========================================");
        System.out.println("|               Zombiepark               |");
        System.out.println("==========================================\n");
        mapa.imprimirMapa();
        System.out.println(" ");
    
    }

    public void caminar() throws InterruptedException, IOException{

        limpiarPantalla();
        player.caminar(mapa);  
        mapa.setPosicion(player.getPosicion().getX(), player.getPosicion().getY()); 
        limpiarPantalla();
        acciones();

    }

    public void infoNodo() throws InterruptedException, IOException{

        limpiarPantalla();
        System.out.println(mapa.getNodoActual());
        acciones();

    }

    public void recogerObjeto() throws InterruptedException, IOException{

        limpiarPantalla();
        player.recogerRecurso(mapa);
        acciones();

    }

    public void inventario() throws InterruptedException, IOException{
        
        limpiarPantalla();
        player.imprimirMochila();
        acciones();

    }

    public void tirarObjeto() throws InterruptedException, IOException{

        limpiarPantalla();
        player.tirarObjeto(mapa);
        acciones();
        
    }
    
}
