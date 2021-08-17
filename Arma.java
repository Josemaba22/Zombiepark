public class Arma extends Recursos{

    int daño;

    public Arma(String nombre,int daño){
        super(nombre);
        this.daño = daño;
    }

    public String toString(){
        return super.nombre;
    }
    
}
