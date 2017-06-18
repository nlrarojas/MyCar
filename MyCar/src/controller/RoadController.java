package controller;

import java.util.Observable;
import java.util.LinkedList;
import java.util.Queue;
import model.Obstacle;
import model.ObstacleGenerator;

public class RoadController extends Observable{

    private int frameSpeed;
    private int imageId;
    
    FileReader document;
    ObstacleGenerator obstacleGenerator;
    Obstacle actualObstacle;
    Queue<String> road;
    
    public RoadController() {
        document = new FileReader();
        obstacleGenerator = new ObstacleGenerator();
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
    
    public Queue chargeRoad(){
        // Cualquier direccion pero estoy usando esta en este caso
        document.readText("C:\\Users\\Yelson\\Documents\\GitHub\\MyCar\\MyCar\\Road.txt"); 
        String text = this.document.getText();
        String[] temporalList = text.split("");
        Queue <String> queue = new LinkedList();
        for (int i = 0; i<temporalList.length; i++){
            queue.add(temporalList[i]);
        }
        return queue;
    }
    public Queue getRoad(){
        road = chargeRoad();
        return road;
    }
    
    public Obstacle getActualObstacle(){
        return obstacleGenerator.generateObstacle(road.poll());
    }
}
