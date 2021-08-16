public class Arma extends Recursos{

    int ataque;

    public Arma(String nombre,int ataque){
        super(nombre);
        this.ataque = ataque;
    }

    public String toString(){
        return super.nombre;
    }
    
}
