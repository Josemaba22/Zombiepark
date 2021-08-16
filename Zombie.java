import java.util.Random;

public class Zombie {

    int salud;
    int ataque;
    Random random;
    final double probabilidadAtaque = 0.5;

    public Zombie(){

        random = new Random();
        salud = 7;
        ataque = 3;
    
    }

    public void atacar(Player player){

        double rnd = random.nextDouble();
        if(rnd > probabilidadAtaque ){
            player.setSalud(player.getSalud() - ataque);
        }

    }

    public int getSalud(){
        return salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

}
