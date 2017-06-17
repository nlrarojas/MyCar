package controller;

import java.util.Observable;
import model.Direction;
import model.Electric;
import model.Engine;
import model.SystemCoordinator;
import model.System;
import model.SystemManager;
import view.RoadView;

public class DashController extends Observable{

    private RoadView RoadPanelView;
    private ThreadController Threads;
    private System DirectionCoordinator;
    private System EngineCoordinator;
    private System ElectricCoordinator;
    
    private System DirectionManager;
    private System EngineManager;
    private System ElectricManager;
    
    public DashController() {
        
    }

    public DashController(RoadView pRoadPanelView, int pFramesImage) {
        DirectionCoordinator = new Direction(new SystemCoordinator());
        EngineCoordinator = new Engine(new SystemCoordinator());
        ElectricCoordinator = new Electric(new SystemCoordinator());
        
        DirectionManager = new Direction(new SystemManager());
        EngineManager = new Engine(new SystemManager());
        ElectricManager = new Electric(new SystemManager());
        
        Threads = new ThreadController(pRoadPanelView, pFramesImage);
        Threads.start();
    }
    
    public void turnLeft(){
        Direction d = (Direction) DirectionCoordinator;
        d.turnLeft();
    }
    
    public void turnRigth(){
        Direction d = (Direction) DirectionCoordinator;
        d.turnRight();
    }
    
    public void speedUp(){
        Engine e = (Engine) EngineCoordinator;
        e.speedUp();
    }
    
    public void slowDown(){
        Engine e = (Engine) EngineCoordinator;
        e.slowDown();
    }
    
    public void switchLigthsState(){
        
    }
    
    public void upGear(){
        Engine e = (Engine) EngineCoordinator;
        e.changeGear("GEAR_UP");
    }
    
    public void downGear(){
        Engine e = (Engine) EngineCoordinator;
        e.changeGear("GEAR_DOWN");
    }
    
    public void setDirectionLeft(){
        
    }
    
    public void setDirectionRigth(){
        
    }
}