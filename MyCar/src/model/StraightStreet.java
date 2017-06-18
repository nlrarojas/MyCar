
package model;

public class StraightStreet extends Obstacle{
    
    public StraightStreet(){
        super();
    }
    
    @Override
    public void generate(boolean b){
        //Para saber si es de noche o de dia
        //true si es de dia, false de lo contrario
        if (day){
            this.path = "src\\images\\carreteraDia\\carreteraDia.png";
        }
        else{
            this.path = "src\\images\\carreteraNoche\\carreteraNoche.png";
        }
    }

    @Override
    public void generate() {
        if (day){
            this.path = "src\\images\\carreteraDia\\carreteraDia" + ((counter++%98) + 1) + ".png";
        }
        else{
            this.path = "src\\images\\carreteraNoche\\carreteraNoche" + ((counter++%98) + 1) + ".png";
        }
    }
}
