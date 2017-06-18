/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Final extends Obstacle{
    
    @Override
    public void generate(boolean b){
        //Para saber si es de noche o de dia
        //true si es de dia, false de lo contrario
        if (b){
            this.path = "src\\images\\carreteraDiaF\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNocheF\\carreteraNoche";
        }
    }

    @Override
    public void generate() {
        if (day){
            this.path = "src\\images\\carreteraDiaF\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNocheF\\carreteraNoche";
        }
    }
}
