package model;

public class Electric extends System {

    private boolean rigthLigthOn;
    private boolean leftLigthOn;
    private boolean lightsOn;
    
    public Electric() {
        rigthLigthOn = false;
        leftLigthOn = false;
        lightsOn = false;
    }
    
    public boolean changeLefthLigthStatus(boolean ligthState){
        return false;
    }
    
    public boolean changeRightLigthStatus(boolean ligthState){
        return false;
    }
    
    public boolean changeLigthsStatus(boolean ligthState){
        return false;
    }
 }