package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import util.IConstants;

public abstract class System implements Runnable, IConstants {

    protected ISystem SystemController;
    protected String instruction;

    protected int speed;
    protected int revolutions;
    protected int gear;
    protected int torque;
    
    protected boolean windShielOn;
    protected boolean lightsOn;
    protected boolean leftOn;
    protected boolean rigthOn;
    
    protected boolean turnRigth;
    protected boolean turnLeft;
    
    private int counter;

    public System(ISystem pSystem) {
        this.SystemController = pSystem;
        this.counter = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (revolutions >= MAXIMUM_REVOLUTIONS){
                    if(counter++ == 100){
                        SystemController.removePoints(PENALTY_POINTS);
                        counter = 0;
                    }
                } else {
                    counter = 0;                
                }
                
                if(turnLeft){
                    if(leftOn){
                        leftOn = false;
                    }else{
                        SystemController.removePoints(PENALTY_POINTS);
                    }
                }
                
                if(turnRigth){                     
                    if(rigthOn){
                        rigthOn = false;
                    }else{
                        SystemController.removePoints(PENALTY_POINTS);
                    }
                }
                
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(System.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public abstract void instructionToExecute(String pInstruction);
    public abstract void turnRight();
    public abstract void turnLeft();
    public abstract void switchWindShieldState();
    public abstract void switchLigthState();
    public abstract void shutDownLigths();
    public abstract void startSimulation(String pFileRoadPath);
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRevolutions() {
        return revolutions;
    }

    public void setRevolutions(int revolutions) {
        this.revolutions = revolutions;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
    
    public boolean isWindShielOn() {
        return windShielOn;
    }

    public void setWindShielOn(boolean windShielOn) {
        this.windShielOn = windShielOn;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public void setLightsOn(boolean lightsOn) {
        this.lightsOn = lightsOn;
    }
    
    public boolean isLeftOn() {
        return leftOn;
    }

    public void setLeftOn(boolean leftOn) {
        this.leftOn = leftOn;
    }

    public boolean isRigthOn() {
        return rigthOn;
    }

    public void setRigthOn(boolean rigthOn) {
        this.rigthOn = rigthOn;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public boolean isTurnRigth() {
        return turnRigth;
    }

    public void setTurnRigth(boolean turnRigth) {
        this.turnRigth = turnRigth;
    }

    public boolean isTurnLeft() {
        return turnLeft;
    }

    public void setTurnLeft(boolean leftRigth) {
        this.turnLeft = leftRigth;
    }
}
