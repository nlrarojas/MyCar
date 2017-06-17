package model;

public abstract class System implements Runnable {

    protected ISystem SystemController;
    protected String instruction;

    protected int speed;
    protected int revolutions;
    protected int gear;
    protected int torque;
    
    protected boolean windShielOn;
    protected boolean lightsOn;
    protected boolean leftOn;
    protected boolean rifthOn;
    
    protected boolean turnRigth;
    protected boolean leftRigth;

    public System(ISystem pSystem) {
        this.SystemController = pSystem;
    }

    @Override
    public void run() {
        while (true) {
            
        }
        //Verificar si la ejecución debe de hacerse aquí
    }

    public abstract void instructionToExecute(String pInstruction);
    public abstract void turnRight();
    public abstract void turnLeft();
    public abstract void switchWindShieldState();
    public abstract void switchLigthState();
    
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

    public boolean isRifthOn() {
        return rifthOn;
    }

    public void setRifthOn(boolean rifthOn) {
        this.rifthOn = rifthOn;
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

    public boolean isLeftRigth() {
        return leftRigth;
    }

    public void setLeftRigth(boolean leftRigth) {
        this.leftRigth = leftRigth;
    }
}
