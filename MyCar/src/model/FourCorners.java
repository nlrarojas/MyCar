/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class FourCorners extends Obstacle{
    
    
    @Override
    public void generate(boolean b){
        //Para saber si es de noche o de dia
        //true si es de dia, false de lo contrario
        if (b){
            this.path = "src\\images\\carreteraDia+\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNoche+\\carreteraNoche";
        }
        
    }

    @Override
    public void generate() {
        if (day){
            this.path = "src\\images\\carreteraDia+\\carreteraDia" + ((counter++ % 98) + 1) + ".png";
        }
        else{
            this.path = "src\\images\\carreteraNoche+\\carreteraNoche" + ((counter++ % 98) + 1) + ".png";
        }
    }
}
