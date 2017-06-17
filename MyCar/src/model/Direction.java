package model;

import util.IConstants;

public class Direction extends System implements IConstants{        
    
    public Direction(ISystem pSystem) {
        super(pSystem);        
    }
    
    @Override
    public void turnRight(){
        instructionToExecute(TURN_RIGTH); 
    }
    
    @Override
    public void turnLeft(){
        instructionToExecute(TURN_LEFT);        
    }

    @Override
    public void instructionToExecute(String pInstruction) {
        SystemController.executeSystemInstruction(pInstruction);
    }   

    @Override
    public void switchWindShieldState() {
        
    }

    @Override
    public void switchLigthState() {
        
    }
}