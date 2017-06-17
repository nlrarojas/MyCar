package controller;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoadController extends Observable implements Runnable{
    private int frameSpeed;
    private int imageId;
    
    private FileReader document;
    private String[] road;
    
    public RoadController() {
        document = new FileReader();
        this.imageId = 0;
    }
    
    public int flipImage(){
        this.setChanged();
        this.notifyObservers();
        imageId = Math.abs(imageId - 1);
        return imageId;
        
        /*        
        imageId = imageId % 14;
        return imageId++;
        */
    }
    
    public String[] chargeRoad(){
        // Cualquier direccion pero estoy usando esta en este caso
        document.readText("C:\\Users\\Yelson\\Documents\\GitHub\\MyCar\\MyCar\\Road.txt"); 
        String text = this.document.getText();
        String[] list = text.split("");
        return list;
    }

    @Override
    public void run() {
        while (true){
            try {
                setChanged();
                notifyObservers();
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(RoadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String[] getRoad(){
        road = chargeRoad();
        return road;
    }
    
    public int getFrameSpeed() {
        return frameSpeed;
    }

    public void setFrameSpeed(int frameSpeed) {
        this.frameSpeed = frameSpeed;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
