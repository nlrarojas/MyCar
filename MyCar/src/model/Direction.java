package model;

import util.IConstants;

public class Direction extends System implements IConstants{        
    
    public Direction(ISystem pSystem) {
        super(pSystem);        
    }
    
    public void turnRight(){
        instructionToExecute(TURN_RIGTH);        
    }
    
    public void turnLeft(){
        instructionToExecute(TURN_LEFT);        
    }

    @Override
    public void instructionToExecute(String pInstruction) {
        SystemController.executeSystemInstruction(pInstruction);
    }   
}