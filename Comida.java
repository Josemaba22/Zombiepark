

public class Comida extends Recursos{

    int recuperacionSalud;
    int recuperacionEnergia;

    public Comida(String nombre,int recuperacionSalud,int recuperacionEnergia){
        super(nombre);
        this.recuperacionSalud = recuperacionSalud;
        this.recuperacionEnergia = recuperacionEnergia;
    }

    public String toString(){
        return super.nombre;
    }
    
}
