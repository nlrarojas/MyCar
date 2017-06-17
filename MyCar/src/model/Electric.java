package model;

import util.IConstants;

public class Electric extends System implements IConstants{

    private boolean windShielOn;
    private boolean lightsOn;
    private boolean leftOn;
    private boolean rifthOn;
    
    public Electric(ISystem pSystem) {
        super(pSystem);
        windShielOn = false;
        lightsOn = false;
        rifthOn = false;
        leftOn = false;
    }
    
    public void setLeftLigthOn(){
        instructionToExecute(TURN_LEFT);
        rifthOn = false;
        leftOn = true;
    }
    
    public void setRigthLigthOn(){
        instructionToExecute(TURN_RIGTH);
        rifthOn = true;
        leftOn = false;
    }
    
    public void switchWindShieldState(){
        instructionToExecute(START_WINDSHIELD);
        if(windShielOn){
            windShielOn = false;
        }else{
            windShielOn = true;
        }
    }
    
    public void switchLigthState() {
        instructionToExecute(START_LIGTHS);
        if(lightsOn){
            lightsOn = false;
        }else{
            lightsOn = true;
        }
    }
    
    @Override
    public void instructionToExecute(String pInstruction) {
        instruction = SystemController.executeSystemInstruction(pInstruction);
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

    public boolean isRifthOn() {
        return rifthOn;
    }

    public void setRifthOn(boolean rifthOn) {
        this.rifthOn = rifthOn;
    }
 }