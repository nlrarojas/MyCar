package model;

public class MinSpeed extends Obstacle{

    private int speedLimit;
    
    MinSpeed(String pSpeedLimit) {
        try{
            this.speedLimit = Integer.parseInt(pSpeedLimit);
        }catch(NumberFormatException e){
            java.lang.System.out.println("isNaN");
        }
    }
    
    @Override
    public void generate(boolean b){
        if (b){
            this.path = "src\\images\\carreteraDiaMin\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNocheMin\\carreteraNoche";
        }
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
