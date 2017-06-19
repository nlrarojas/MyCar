package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;
import model.Direction;
import model.Electric;
import model.Engine;
import model.SystemCoordinator;
import model.System;
import model.SystemManager;
import util.IConstants;
import view.RoadView;

public class DashController extends Observable implements IConstants{       
    private System DirectionCoordinator;
    private System EngineCoordinator;
    private System ElectricCoordinator;
    
    private System DirectionManager;
    private System EngineManager;
    private System ElectricManager;
    
    private Evaluator PlayerEvaluator;
    
    private Timer TimerUpdater;
    
    public DashController(RoadView pRoadPanelView, int pFramesImage, view.Dash pDash, Evaluator pPlayerEvaluator) {
        PlayerEvaluator = pPlayerEvaluator;
        DirectionCoordinator = new Direction(new SystemCoordinator(pRoadPanelView, PlayerEvaluator));
        EngineCoordinator = new Engine(new SystemCoordinator(pRoadPanelView, PlayerEvaluator));
        ElectricCoordinator = new Electric(new SystemCoordinator(pRoadPanelView, PlayerEvaluator));
        
        DirectionManager = new Direction(new SystemManager());
        EngineManager = new Engine(new SystemManager());
        ElectricManager = new Electric(new SystemManager());                             
        
        TimerUpdater = new Timer(250, (ActionEvent e) -> {
            setChanged();
            notifyObservers();
        });                
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
        e.changeGear(GEAR_UP);
        setChanged();
        notifyObservers();
    }
    
    public void downGear(){
        Engine e = (Engine) EngineCoordinator;
        e.changeGear(GEAR_DOWN);
        setChanged();
        notifyObservers();
    }
    
    public void starWindShield(){
        Electric e = (Electric) ElectricCoordinator;
        e.switchWindShieldState();
        setChanged();
        notifyObservers();
    }
    
    public void setFileRoadPath(String pFileRoad){    
        EngineCoordinator.startSimulation(pFileRoad);
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

    public Evaluator getPlayerEvaluator() {
        return EngineCoordinator.getPlayerEvaluator();
    }

    public void setPlayerEvaluator(Evaluator PlayerEvaluator) {
        this.PlayerEvaluator = PlayerEvaluator;
    }

    public Timer getTimerUpdater() {
        return TimerUpdater;
    }

    public void setTimerUpdater(Timer TimerUpdater) {
        this.TimerUpdater = TimerUpdater;
    }
}