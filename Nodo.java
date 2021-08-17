import java.util.ArrayList;
import java.util.Random;


public class Nodo {

    ArrayList<Zombie> zombies;
    ArrayList<Recursos> recursos;
    int x;
    int y;
    Random random;
    boolean estanciaPlayer = false;

    public Nodo(int x,int y){

        this.x = x;
        this.y = y;
        random = new Random();
        zombies = new ArrayList<Zombie>();
        recursos = new ArrayList<Recursos>();
        crearZombies();
        crearRecursos();
    
    }

    public void crearZombies(){

        double rnd = random.nextDouble();
        // ZOMBIES: 1
        if(rnd < 0.2){
            zombies.add(new Zombie());
        }
        // ZOMBIES: 2
        if(rnd > 0.2 && rnd < 0.4){
            zombies.add(new Zombie());
            zombies.add(new Zombie());
        }
        //  ZOMBIES: 3
        if(rnd > 0.4 && rnd < 0.5){
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
        }
        // ZOMBIES: 10
        if(rnd == 0.999){
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
            zombies.add(new Zombie());
        }

    }

    public boolean invacionZombie(){
        
        if(zombies.isEmpty()) return false;
        else return true;

    }

    public void crearRecursos(){

        int randomInt = random.nextInt(5);
        int i = 0;
        while(i < randomInt){
            double randomDouble = random.nextDouble();
            if(randomDouble > 0.1 && randomDouble < 0.2){
                recursos.add(new Arma("Hang-gun", 10));
            }
            if(randomDouble > 0.2 && randomDouble < 0.4){
                recursos.add(new Comida("Pan", 10, 5));
            }
            if(randomDouble > 0.4 && randomDouble < 0.5){
                recursos.add(new Comida("Botella de Agua", 5, 5));
            }
            i++;
        }
        
    }

    public void setEstanciaPlayer(boolean bool){

        estanciaPlayer = bool;

    }

    public void imprimirNodo(){

        if(x == 0 && y > 0) System.out.print("  "+y);
        if(x > 0 && y == 0) System.out.print(x+"   ");
        if(x == 0 && y == 0) System.out.print("y/x");
        if(x > 0 && y > 0){
            if(estanciaPlayer)System.out.print("[X]");
            else System.out.print("[ ]");
        }

    }

    public String toString(){
        
        String str = "";
        str += "\n----------------------"+
            "\nNODO INFO"+
            "\n----------------------";
        str += "\nPunto: [ "+x+", "+y+" ]";  
        str += "\nZombies: " + zombies.size();
        str += "\nRecursos: " + recursos.size();
        for(int i = 0; i < recursos.size(); i++){
            str += "\n  -" + recursos.get(i);
        }
        str += "\n----------------------";
        return str;
    
    }

}
