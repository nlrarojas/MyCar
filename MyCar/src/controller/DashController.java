package controller;

import java.util.Observable;
import model.Simulator;
import view.RoadView;

public class DashController extends Observable{

    private RoadView RoadPanelView;
    private ThreadController Threads;
    private Simulator DrivingSimulator;
    
    public DashController() {

    }

    public DashController(RoadView pRoadPanelView, int pFramesImage) {
        Threads = new ThreadController(pRoadPanelView, pFramesImage);
        Threads.start();
    }
    
    public void turnLeft(){
        
    }
    
    public void turnRigth(){
        
    }
    
    public void speedUp(){
        
    }
    
    public void slowDown(){
        
    }
}