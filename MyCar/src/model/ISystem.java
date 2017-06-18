package model;

import controller.RoadController;
import controller.ThreadController;

public interface ISystem {   
    public String  executeSystemInstruction(String  pInstuctionValue);
    public int removePoints(int pPoints);
    public void updateSpeed(int pSpeed);
    public void startSimulation(String pFileRoadPath);
    
    public static ThreadController THREADS = ThreadController.getInstance();
    public static RoadController ROAD = new RoadController();        
}