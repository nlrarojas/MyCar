package model;
/**
 *
 * @author Nelson
 */

public abstract class Obstacle {
    protected String path;
    protected boolean day;
    protected int counter;
    protected boolean rainning;
    
    public Obstacle() {
        this.path = "";
        this.day = true;
        this.counter = 0;
        this.rainning = false;        
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isRainning() {
        return rainning;
    }

    public void setRainning(boolean rainning) {
        this.rainning = rainning;
    }
}
