package model;

import util.IConstants;

public class Electric extends System implements IConstants{

    private boolean rigthLigthOn;
    private boolean leftLigthOn;
    private boolean lightsOn;
    
    public Electric(ISystem pSystem) {
        super(pSystem);
        rigthLigthOn = false;
        leftLigthOn = false;
        lightsOn = false;
    }
    
    public void setLeftLigthOn(){
        instructionToExecute(TURN_LEFT);
    }
    
    public void setRigthLigthOn(){
        instructionToExecute(TURN_RIGTH);
    }
    
    public void setWindShieldOn(){
        instructionToExecute(START_WINDSHIELD);
    }
    
    public void setWindShieldOff(){
        instructionToExecute(STOP_WINDSHIELD);
    }
    
    @Override
    public void instructionToExecute(String pInstruction) {
        instruction = SystemController.executeSystemInstruction(pInstruction);
    }
 }