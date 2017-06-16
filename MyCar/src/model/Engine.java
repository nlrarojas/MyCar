package model;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import util.IConstants;

public class Engine extends System implements IConstants{

    private boolean speed;
    private int revolutions;
    private int gear;
    private Timer TimerRevolutions;
    private boolean revolutionsPassed;
    private int timeExitingRevolutionLimit;
    private int torque;
    
    public Engine() {        
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
    
    public boolean changeGear(boolean pUpGear){
        if(pUpGear){
            if(gear < 5){
                gear++;
                return true;
            }else{
                return false;
            }
        }else{
            if(gear > 0){
                gear--;
                return true;
            }else{
                return false;
            }
        }
    }
    
    public boolean speedUp(){
        if(gear != 0){
            if(revolutions >= MAXIMUM_REVOLUTIONS){
                TimerRevolutions.start();
            }else{
                revolutions = (int) (torque++ + 7.27) / (100/2750);
            }
            java.lang.System.out.println(revolutions);
        }
        return false;
    }
}