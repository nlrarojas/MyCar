/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Day extends Obstacle{
    
    public Day(){
        super();
        day = true;
    }
            
    
    @Override
    public void generate(boolean b){
        this.path = "src\\images\\carreteraDia\\carreteraDia";
    }

    @Override
    public void generate() {
        
    }

    @Override
    public boolean isDay() {
        return true;
    }

    @Override
    public void setDay(boolean day) {
        this.day = true;
    }
    
    
}
