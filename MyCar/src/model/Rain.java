
package model;

public class Rain extends Obstacle{
    @Override
    public void generate(boolean b){
        if (b){
            this.path = "src\\images\\carreteraDiaL\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNocheL\\carreteraNoche";
        }
    }

    @Override
    public void generate() {
        
    }
}
