package controller;

import java.util.Observable;
import java.util.LinkedList;
import java.util.Queue;
import model.Obstacle;
import model.ObstacleGenerator;
import model.StraightStreet;

public class RoadController extends Observable implements Runnable {

    private int frameSpeed;
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
        this.runRoadController = false;
    }

    public RoadController(int pFrameSpeed) {
        this.frameSpeed = pFrameSpeed;
        this.Document = new FileReader();
        this.ObstacleGenerator = new ObstacleGenerator();
        this.runRoadController = false;
    }

    @Override
    public void run() {
        road = chargeRoad();
        int t = 0;
        System.out.println(frameSpeed);
        while (true) {
            System.out.print("");
            while (this.runRoadController){                                
                try {                              
                    if(actualObstacle != null){                        

                        if(!actualObstacle.getClass().equals(model.Final.class)){                        
                            actualObstacle = getNextActualObstacle();
                            if(actualObstacle.getClass().equals(model.Day.class)){
                                actualObstacle = ObstacleGenerator.generateObstacle(".");                            
                            }else if(actualObstacle.getClass().equals(model.Night.class)){
                                actualObstacle = ObstacleGenerator.generateObstacle(".");
                                StraightStreet ss = (StraightStreet) actualObstacle;
                                ss.setDay(false);
                            }
                        }
                    }else{
                        actualObstacle = getNextActualObstacle();
                    }
                    
                    
                    while (t++ < 100){
                        //imprime imagen                        
                        setChanged();
                        notifyObservers();
                        Thread.sleep(frameSpeed);
                    }                    
                    t = 0;                    
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
//=======
//        Queue <String> queue = new LinkedList();
//        String temp = "";
//        //Compara los strings 
//        //Guarda los obstaculos en una cola
//        for (int i = 0; i<temporalList.length; i++){
//            String obst = temporalList[i];
//            if (isNumber(obst)){
//                temp+=obst;
//            }
//            else{
//                if("m".equals(obst) || "M".equals(obst)){
//                    temp += obst;
//                }
//                else{
//                    if (!"".equals(temp)){
//                        queue.add(temp);
//                        queue.add(obst);
//                        temp = "";
//                    }
//                    else{
//                        queue.add(obst);
//                    }
//                    
//                }
//            }
//        }
//>>>>>>> origin/Yelson
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
    
    public ObstacleGenerator getObstacleGenerator() {
        return ObstacleGenerator;
    }
    
    public boolean isNumber(String str){
        try{
            Integer i = Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }
        
    
}
