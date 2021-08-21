import java.util.ArrayList;

public class Player {
    
    Punto posicion;
    String nombre;
    Recursos[] mochila;
    int salud;
    int contadorZombies;
    int fuerza;
    int energia;

    public Player(String nombre){

        this.nombre = nombre;
        posicion = new Punto(5,5);
        salud = 10;
        contadorZombies = 0;
        fuerza = 3;
        energia = 10;
        mochila =  new Recursos[5];
        
    }

    public void atacar(){}

    public void comer(){}

    public void beber(){}

    public void caminar(Mapa mapa){
        
        String mando;
        do{
            System.out.print("a.-Izquierda\nd.-Derecha\nw.-Arriba\ns.-Abajo"+
                "\nEscriba solo una (a,w,s,d) : ");
            
            mando = Keyboard.readString();

            if(mando.equals("a") || mando.equals("w") || mando.equals("s") || mando.equals("d")){
                int xAux = posicion.getX();
                int yAux = posicion.getY();
                if(mando.equals("w")){
                    xAux--;
                    if(xAux < 1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VINISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (a,s,d): ");       
                    }
                    else break;
                }
                if(mando.equals("a")){
                    yAux--; 
                    if(yAux < 1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VINISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (w,s,d): ");
                    }
                    else break;
                }
                if(mando.equals("s")){
                    xAux++; 
                    if(xAux > mapa.matrizMapa.length-1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VINISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (a,w,d): ");
                    }
                    else break;
                }
                if(mando.equals("d")){
                    yAux++; 
                    if(yAux > mapa.matrizMapa.length-1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VINISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (a,w,s): ");
                    }
                    else break;                    
                }
            }
            else System.out.println("VALOR INVALIDO! Escriba solo (a,w,s,d): ");

        }while(true);

        mapa.matrizMapa[posicion.getX()][posicion.getY()].setEstanciaPlayer(false);
        switch(mando){
            case "w": 
                posicion.menosX();
                mapa.matrizMapa[posicion.getX()][posicion.getY()].setEstanciaPlayer(true);
                break;
            
            case "a":
                posicion.menosY();
                mapa.matrizMapa[posicion.getX()][posicion.getY()].setEstanciaPlayer(true);
                break;
            
            case "s":
                posicion.masX();
                mapa.matrizMapa[posicion.getX()][posicion.getY()].setEstanciaPlayer(true);
                break;
            
            case "d":
                posicion.masY();
                mapa.matrizMapa[posicion.getX()][posicion.getY()].setEstanciaPlayer(true);
                break;
        }

    }

    public void recogerRecurso(Mapa mapa){

        if(!mapa.getNodoActual().recursos.isEmpty()){
            if(mochila[mochila.length-1] == null){
                ArrayList<Recursos> recursosAux = mapa.getNodoActual().imprimirRecursos();
                int opcion;
                do{
        
                    System.out.print("Recoger recurso -> Opción: ");
                    opcion = Keyboard.readInt();
                    if(opcion < 1 || opcion > recursosAux.size())System.out.println("VALOR INVALIDO!");
                    else break;
        
                }while(true);
                for(int i = 0; i < mochila.length; i++){
                    if(mochila[i] == null){
                        mochila[i] = recursosAux.get(opcion-1);
                        System.out.println("Recogiste: "+mochila[i]);
                        mapa.getNodoActual().recursos.remove(opcion-1);
                        break;
                    } 
                }
            }else System.out.println("MOCHILA LLENA! Podrias tirar algun objeto...");
        }else System.out.println("NO HAY OBJETOS EN ESTA ZONA...");

    }

    public void tirarObjeto(Mapa mapa){

        imprimirMochila();

        if(mochila[0] != null){

            // Pedir por teclado una opcion
            int opcion;
            do{
    
                System.out.print("Tirar Objeto -> Opción: ");
                opcion = Keyboard.readInt();
                if(opcion < 1 || opcion > mochila.length)System.out.println("VALOR INVALIDO!");
                else {
                    opcion--;
                    if(mochila[opcion] == null){
                    System.out.println("No hay objetos en esa opción...");
                    } else break;
                }
    
            }while(true);
    
            // Depositar objeto en el nodo actual del mapa
            mapa.getNodoActual().recursos.add(mochila[opcion]);
            System.out.println("Tiraste el objeto: "+mochila[opcion]);
            mochila[opcion] = null;
            
            // Ordenar nulls en mochila
            Recursos mochilaAux[] = new Recursos[5];
            int i = 0;
            int j = 0;
            int k = mochilaAux.length-1;
            while( i < mochila.length ){
                if(mochila[i] != null){
                    mochilaAux[j] = mochila[i];
                    i++;
                    j++;
                }else {
                    mochilaAux[k] = null;
                    i++;
                    k--;
                }
            }
            mochila = mochilaAux; // Mochila ordenada

        }else System.out.println("No hay objetos que tirar...");

    }

    public void imprimirMochila(){
        
        System.out.println("\n----------------------"+
                            "\nINVENTARIO"+
                            "\n----------------------");
        for(int i = 0; i < mochila.length; i++){
            System.out.println((i+1)+".-"+mochila[i]);
        }
        System.out.println("----------------------");
        
    }

    public int getSalud(){
        return salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public void escarbar(Nodo nodo){

    }

    public void morir(){
        System.out.println("Has muerto, GAME OVER...");
    }

    public Punto getPosicion(){
        return posicion;
    }
}
