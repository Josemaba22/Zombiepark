public class Punto {
    
    int x;
    int y;

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "["+x+","+y+"]";
    }

    public void masX(){
        x++;
    }

    public void menosX(){
        x--;
    }

    public void masY(){
        y++;
    }

    public void menosY(){
        y--;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }
}
