package controller;

import java.util.Observable;

public class RoadController extends Observable{

    private int frameSpeed;
    private int imageId;
    
    public RoadController(int pFrameSpeed) {
        this.frameSpeed = pFrameSpeed;
        this.imageId = 0;
    }
    
    public int flipImage(){
        this.setChanged();
        this.notifyObservers();
        imageId = Math.abs(imageId - 1);
        return imageId;
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