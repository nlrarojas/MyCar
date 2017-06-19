/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Intersection extends Obstacle{
    
    @Override
    public void generate(boolean b){
        if (b){
            this.path = "src\\images\\carreteraDiaT\\carreteraDia";
        }
        else{
            this.path = "src\\images\\carreteraNocheT\\carreteraNoche";
        }
    }

    @Override
    public void generate() {
        if (day){
            this.path = "src\\images\\carreteraDiaT\\carreteraDia" + ((counter++ % 98) + 1) + ".png";
        }
        else{
            this.path = "src\\images\\carreteraNocheT\\carreteraNoche" + ((counter++ % 98) + 1) + ".png";
        }
    }
}
