package model;
/**
 *
 * @author Nelson
 */

public abstract class Obstacle {
    protected String path;
    protected boolean day;
    protected int counter;
    
    public Obstacle() {
        this.path = "";
        this.day = true;
        this.counter = 0;
    }
    
    public abstract void generate();
    
    public abstract void generate(boolean b);
        //Aqui en donde los debe pintar, (pero en cada imagen)
        //cuando esté todas las imagenes listas se lo implemento
    
    public String getPath() {
        return path;
    }
    
    public boolean isDay() {
        return day;
    }

    public void setDay(boolean day) {
        this.day = day;
    }
}
