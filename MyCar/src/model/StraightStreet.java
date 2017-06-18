
package model;

public class StraightStreet extends Obstacle{
    public void generate(boolean b){
        //Para saber si es de noche o de dia
        //true si es de dia, false de lo contrario
        if (b){
            this.path = "src\\images\\carreteraDia\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNoche\\carreteraNoche";
        }
    }
}
