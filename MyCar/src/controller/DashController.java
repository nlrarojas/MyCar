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

    private RoadController Road;
    private ThreadController Threads;
    
    private System DirectionCoordinator;
    private System EngineCoordinator;
    private System ElectricCoordinator;
    
    private System DirectionManager;
    private System EngineManager;
    private System ElectricManager;

    public DashController(RoadView pRoadPanelView, int pFramesImage, view.Dash pDash) {
        DirectionCoordinator = new Direction(new SystemCoordinator());
        EngineCoordinator = new Engine(new SystemCoordinator());
        ElectricCoordinator = new Electric(new SystemCoordinator());
        
        DirectionManager = new Direction(new SystemManager());
        EngineManager = new Engine(new SystemManager());
        ElectricManager = new Electric(new SystemManager());
                
        Road = new RoadController();
        
        Threads = ThreadController.getInstance();
        Threads.addTaskToExecutor(Road);
        Threads.start();
        this.addObserver(pDash); 
    }
    
    public void turnLeft(){
        DirectionCoordinator.turnLeft();
        setChanged();
        notifyObservers();
    }
    
    public void turnRigth(){
        DirectionCoordinator.turnRight();
        setChanged();
        notifyObservers();
    }
    
    public void startRigthLigth(){
        ElectricCoordinator.turnRight();
        setChanged();
        notifyObservers();
    }
    
    public void startLeftLigth(){
        ElectricCoordinator.turnLeft();
        setChanged();
        notifyObservers();
    }
    
    public void speedUp(){
        Engine e = (Engine) EngineCoordinator;
        e.speedUp();
        setChanged();
        notifyObservers();
    }
    
    public void slowDown(){
        Engine e = (Engine) EngineCoordinator;
        e.slowDown();
        setChanged();
        notifyObservers();
    }
    
    public void switchLigthsState(){
        ElectricCoordinator.switchLigthState();
        setChanged();
        notifyObservers();
    }
    
    public void upGear(){
        Engine e = (Engine) EngineCoordinator;
        e.changeGear("GEAR_UP");
        setChanged();
        notifyObservers();
    }
    
    public void downGear(){
        Engine e = (Engine) EngineCoordinator;
        e.changeGear("GEAR_DOWN");
        setChanged();
        notifyObservers();
    }
    
    public void starWindShield(){
        Electric e = (Electric) ElectricCoordinator;
        e.switchWindShieldState();
        setChanged();
        notifyObservers();
    }
    
    public void shutDownLigths(){
        Electric e = (Electric) ElectricCoordinator;
        e.shutDownLigths();
        setChanged();
        notifyObservers();
    }

    public System getDirectionCoordinator() {
        return DirectionCoordinator;
    }

    public void setDirectionCoordinator(System DirectionCoordinator) {
        this.DirectionCoordinator = DirectionCoordinator;
    }

    public System getEngineCoordinator() {
        return EngineCoordinator;
    }

    public void setEngineCoordinator(System EngineCoordinator) {
        this.EngineCoordinator = EngineCoordinator;
    }

    public System getElectricCoordinator() {
        return ElectricCoordinator;
    }

    public void setElectricCoordinator(System ElectricCoordinator) {
        this.ElectricCoordinator = ElectricCoordinator;
    }

    public System getDirectionManager() {
        return DirectionManager;
    }

    public void setDirectionManager(System DirectionManager) {
        this.DirectionManager = DirectionManager;
    }

    public System getEngineManager() {
        return EngineManager;
    }

    public void setEngineManager(System EngineManager) {
        this.EngineManager = EngineManager;
    }

    public System getElectricManager() {
        return ElectricManager;
    }

    public void setElectricManager(System ElectricManager) {
        this.ElectricManager = ElectricManager;
    }
}