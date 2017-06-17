package model;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import util.IConstants;

public class Engine extends System implements IConstants{

    private int speed;
    private int revolutions;
    private int gear;
    private Timer TimerRevolutions;
    private boolean revolutionsPassed;
    private int timeExitingRevolutionLimit;
    private int torque;
    
    public Engine(ISystem pSystem) {
        super(pSystem);
        this.revolutionsPassed = false;
        this.timeExitingRevolutionLimit = 0;
        this.torque = 1;
        
        TimerRevolutions = new Timer(1000, (ActionEvent e) -> {
            if(revolutionsPassed)
                TimerRevolutions.stop();                
            else if(timeExitingRevolutionLimit++ == 10)
                    revolutionsPassed = true;            
        });
    }
    
    public int changeGear(String pUpGear){
        if(pUpGear.equals(GEAR_UP)){
            if(gear < 5){
                gear++;
                return gear;
            }
        }else{
            if(gear > 0){
                gear--;
                return gear;
            }
        }
        return 0;
    }
    
    public int speedUp(){
        if(gear != 0){
            if(revolutions >= MAXIMUM_REVOLUTIONS){
                TimerRevolutions.start();
            }else{
                revolutions = (int) ((torque++ + 7.27) / (100.0/2750.0));
            }
            java.lang.System.out.println(revolutions);
        speed = speedCalculation();
        }
        return revolutions;
    }
    
    public int slowDown(){
        if(gear != 0){
            if(revolutions > 0){
                revolutions = (int) (torque-- + 7.27) / (100/2750);
            }
            java.lang.System.out.println(revolutions);
        speed = speedCalculation();
        }        
        return revolutions;
    }

    private int speedCalculation(){
        if (speed < MAX_VELOCITY[gear])
            return (int)(((double)revolutions + 1.5416728) / 33.67650272);
        return speed;
    }
    @Override
    public void instructionToExecute(String pInstruction) {
        instruction = SystemController.executeSystemInstruction(pInstruction);
    }
}