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
        if (b){
            this.path = "src\\images\\carreteraDiaMax\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNocheMax\\carreteraNoche";
        }
    }

    @Override
    public void generate() {
        if (day){
            this.path = "src\\images\\carreteraNocheMax\\carreteraDia" + ((counter++ % 98) + 1) + ".png";
        }
        else{
            this.path = "src\\images\\carreteraNocheMax\\carreteraNoche"  + ((counter++ % 98) + 1) + ".png";
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
