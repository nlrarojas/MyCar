package controller;

import java.util.Observable;

public class RoadController extends Observable{

    private int frameSpeed;
    private int imageId;
    
    FileReader document;
    String[] road;
    
    public RoadController() {
        document = new FileReader();
    }
    
    public RoadController(int pFrameSpeed) {
        this.frameSpeed = pFrameSpeed;
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
    
    public String[] chargeRoad(){
        // Cualquier direccion pero estoy usando esta en este caso
        document.readText("C:\\Users\\Yelson\\Documents\\GitHub\\MyCar\\MyCar\\Road.txt"); 
        String text = this.document.getText();
        String[] list = text.split("");
        return list;
    }
    public String[] getRoad(){
        road = chargeRoad();
        return road;
    }
}
