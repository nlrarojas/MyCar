package model;

public class MaxSpeed extends Obstacle{

    private int speedLimit;
    
    MaxSpeed(String pSpeedLimit) {
        try{
            this.speedLimit = Integer.parseInt(pSpeedLimit);
        }catch(NumberFormatException e){
            java.lang.System.out.println("isNaN");
        }
    }
    
    @Override
    public void generate(boolean b){
        
    }

    @Override
    public void generate() {
        
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
