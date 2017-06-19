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
            this.path = "src\\images\\carreteraDiaMin\\carreteraDia" + ((counter++ % 98) + 1) + ".png";
        }
        else{
            this.path = "src\\images\\carreteraNocheMin\\carreteraNoche"  + ((counter++ % 98) + 1) + ".png";
        }
    }

    @Override
    public void generate() {
        if (day){
            this.path = "src\\images\\carreteraDiaMin\\carreteraDia" + ((counter++ % 98) + 1) + ".png";
        }
        else{
            this.path = "src\\images\\carreteraNocheMin\\carreteraNoche"  + ((counter++ % 98) + 1) + ".png";
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
