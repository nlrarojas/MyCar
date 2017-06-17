package model;

import util.IConstants;

public class Electric extends System implements IConstants{
    
    public Electric(ISystem pSystem) {
        super(pSystem);
        windShielOn = false;
        lightsOn = false;
        rigthOn = false;
        leftOn = false;
    }
    
    @Override
    public void turnLeft(){
        instructionToExecute(TURN_LEFT);
        rigthOn = false;
        leftOn = true;
    }
    
    @Override
    public void turnRight(){
        instructionToExecute(TURN_RIGTH);
        rigthOn = true;
        leftOn = false;
    }
    
    @Override
    public void shutDownLigths() {
        instructionToExecute(NONE_INSTRUCTION);
        rigthOn = false;
        leftOn = false;
    }
    
    @Override
    public void switchWindShieldState(){
        instructionToExecute(START_WINDSHIELD);
        windShielOn = !windShielOn;
    }
    
    @Override
    public void switchLigthState() {
        instructionToExecute(START_LIGTHS);
        lightsOn = !lightsOn;
    }
    
    @Override
    public void instructionToExecute(String pInstruction) {
        instruction = SystemController.executeSystemInstruction(pInstruction);
    }
 }