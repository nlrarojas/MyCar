package controller;

import java.util.Observable;
import java.util.LinkedList;
import java.util.Queue;
import model.Obstacle;
import model.ObstacleGenerator;

public class RoadController extends Observable implements Runnable {

    private int frameSpeed;
    private int imageId;
    private boolean runRoadController;
    private String filePath;
    
    private FileReader Document;
    private ObstacleGenerator ObstacleGenerator;
    private Obstacle actualObstacle;
    private Queue<String> road;

    public RoadController() {
        this.Document = new FileReader();
        this.ObstacleGenerator = new ObstacleGenerator();
        this.frameSpeed = 0;
        this.imageId = 0;
        this.runRoadController = false;
    }

    public RoadController(int pFrameSpeed) {
        this.frameSpeed = pFrameSpeed;
        this.imageId = 0;
        this.Document = new FileReader();
        this.ObstacleGenerator = new ObstacleGenerator();
        this.runRoadController = false;
    }

    public int flipImage() {
        this.setChanged();
        this.notifyObservers();
        imageId = Math.abs(imageId - 1);
        return imageId;

        /*        
        imageId = imageId % 14;
        return imageId++;
         */
    }

//    public String[] chargeRoad(){
//        // Cualquier direccion pero estoy usando esta en este caso
//        document.readText("C:\\Users\\Yelson\\Documents\\GitHub\\MyCar\\MyCar\\Road.txt"); 
//        String text = this.document.getText();
//        String[] list = text.split("");
//        return list;
//    }
    @Override
    public void run() {
        road = chargeRoad();
        while (true) {
            System.out.println("i");
            while (this.runRoadController){                                
                try {                                        
                    if(!actualObstacle.getClass().equals(model.Final.class)){                        
                        actualObstacle = getNextActualObstacle();              
                    }
                    setChanged();
                    notifyObservers();

                    Thread.sleep(frameSpeed);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                if(!this.runRoadController){                    
                    ThreadController.getInstance().setThreadStarted(false);
                    break;
                }
            }            
        }
    }

    public int getFrameSpeed() {
        return frameSpeed;
    }

    public void setFrameSpeed(int frameSpeed) {        
        this.frameSpeed = frameSpeed;
        this.runRoadController = true;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Queue chargeRoad() {
        // Cualquier direccion pero estoy usando esta en este caso
        Document.readText(filePath);
        String text = this.Document.getText();
        String auxiliarText = "";
        String[] temporalList = text.split("");
        Queue<String> queue = new LinkedList();
        for (int i = 0; i < temporalList.length; i++) {
            if(temporalList[i].equalsIgnoreCase("m")){
                auxiliarText = temporalList[i++];
                while(true){
                    try{
                        if(temporalList[i].equals(".")){
                            queue.add(auxiliarText);
                            queue.add(temporalList[i]);
                            auxiliarText = "";
                            break;
                        }
                        auxiliarText += Integer.parseInt(temporalList[i++]);
                    }catch (NumberFormatException e){
                        queue.add(auxiliarText);
                        auxiliarText = "";
                        break;
                    }
                }
            }else{
                queue.add(temporalList[i]);
            }                        
        }
        System.out.println(queue.toString());        
        return queue;
    }

    public Queue getRoad() {
        road = chargeRoad();
        return road;
    }

    public Obstacle getNextActualObstacle() {
        if(!road.isEmpty()){
            return ObstacleGenerator.generateObstacle(road.poll());
        }
        return null;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Obstacle getActualObstacle() {
        return actualObstacle;
    }

    public void setActualObstacle(Obstacle actualObstacle) {
        this.actualObstacle = actualObstacle;
    }

    public boolean isRunRoadController() {
        return runRoadController;
    }

    public void setRunRoadController(boolean runRoadController) {
        this.runRoadController = runRoadController;
    }
}
