package model;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import util.IConstants;

public class Engine extends System implements IConstants, Runnable {

    private Timer TimerRevolutions;
    private boolean revolutionsPassed;
    private int timeExitingRevolutionLimit;

    public Engine(ISystem pSystem) {
        super(pSystem);
        this.revolutionsPassed = false;
        this.timeExitingRevolutionLimit = 0;
        this.torque = 1;
        
        TimerRevolutions = new Timer(1000, (ActionEvent e) -> {
            if (revolutionsPassed) {
                TimerRevolutions.stop();
            } else if (timeExitingRevolutionLimit++ == 10) {
                revolutionsPassed = true;
            }
        });
    }

    public int changeGear(String pUpGear) {
        if (pUpGear.equals(GEAR_UP)) {
            if (gear < 5) {
                if (revolutions > MAX_RPM[gear]) {
                    revolutions = (int) (MAX_RPM[gear] * 1.30);
                    speed = speedRaiseCalculation();
                }
                gear++;
                return gear;
            }
        } else if (gear > 0) {
            gear--;
            return gear;
        }
        return 0;
    }

    public int speedUp() {
        if (gear != 0) {
            if (revolutions >= MAXIMUM_REVOLUTIONS) {
                TimerRevolutions.start();
            } else {
                revolutions = (int) ((torque++ + 7.27) / (100.0 / 2750.0));
            }
            speed = speedRaiseCalculation();
            instructionToExecute(SPEED_UP_ENGINE);
        }
        return revolutions;
    }

    public int slowDown() {
        if(gear != 0){
            if (revolutions > 0) {
                revolutions = (int) ((torque-- + 7.27) / (100.0 / 2750.0));
            }
            speed = speedLowCalculation();
            instructionToExecute(SLOW_DOWN_ENGINE);
        }
        return revolutions;
    }

    private int speedRaiseCalculation() {
        if (speed < MAX_VELOCITY[gear]) {
            return (int) (((double) revolutions + 1.5416728) / 33.67650272);
        }
        return speed;
    }

    private int speedLowCalculation() {
        return (int) (((double) revolutions + 1.5416728) / 33.67650272);
    }

    public int speedToKmH() {
        return (speed * 3600) / 1000;
    }

    @Override
    public void instructionToExecute(String pInstruction) {
        instruction = SystemController.executeSystemInstruction(pInstruction);
        SystemController.updateSpeed((100 / speed) * 10);
    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void switchWindShieldState() {

    }

    @Override
    public void switchLigthState() {

    }

    @Override
    public void shutDownLigths() {

    }
    
    @Override
    public void startSimulation(String pFileRoadPath) {
        SystemController.startSimulation(pFileRoadPath);        
    }
}