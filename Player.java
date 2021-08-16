public class Player {
    
    int x;
    int y;
    String nombre;
    Recursos[] mochila;
    int salud;
    int contadorZombies;
    int ataque;
    int energia;

    public Player(String nombre){

        this.nombre = nombre;
        x = 5;
        y = 5;
        salud = 10;
        contadorZombies = 0;
        ataque = 3;
        energia = 10;
        mochila =  new Recursos[5];
        
    }

    public void atacar(){}

    public void comer(){}

    public void beber(){}

    public void caminar(Mapa mapa){
        
        String flechaA = "\u05D0";
        System.out.print("Escriba solo una (a,w,s,d) : "+flechaA);
        String mando;
        do{
            
            mando = Keyboard.readString();
            if(mando.equals("a") || mando.equals("w") || mando.equals("s") || mando.equals("d")){
                int xAux = x;
                int yAux = y;
                if(mando.equals("w")){
                    xAux--;
                    if(xAux < 1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VENISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (a,s,d): ");       
                    }
                    else break;
                }
                if(mando.equals("a")){
                    yAux--; 
                    if(yAux < 1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VENISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (w,s,d): ");
                    }
                    else break;
                }
                if(mando.equals("s")){
                    xAux++; 
                    if(xAux > mapa.matrizMapa.length-1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VENISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (a,w,d): ");
                    }
                    else break;
                }
                if(mando.equals("d")){
                    yAux++; 
                    if(yAux > mapa.matrizMapa.length-1){
                        System.out.println("MUERTE SEGURA! VUELVE POR DONDE VENISTE!");
                        System.out.println("VALOR INVALIDO! Escriba solo (a,w,s): ");
                    }
                    else break;                    
                }
            }
            else System.out.println("VALOR INVALIDO! Escriba solo (a,w,s,d): ");

        }while(true);

        mapa.matrizMapa[x][y].setEstanciaPlayer(false);
        switch(mando){
            case "w": 
                x--;
                mapa.matrizMapa[x][y].setEstanciaPlayer(true);
                break;
            
            case "a":
                y--; 
                mapa.matrizMapa[x][y].setEstanciaPlayer(true);
                break;
            
            case "s":
                x++; 
                mapa.matrizMapa[x][y].setEstanciaPlayer(true);
                break;
            
            case "d":
                y++; 
                mapa.matrizMapa[x][y].setEstanciaPlayer(true);
                break;
        }

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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
