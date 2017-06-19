/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Night extends Obstacle{
 
    public Night(){
        super();
        this.day = false;
    }
    
    @Override
    public void generate(boolean b){
        this.path = "src\\images\\carreteraNoche\\carreteraNoche";
    }

    @Override
    public void generate() {
        
    }

    @Override
    public boolean isDay() {
        return false;
    }

    @Override
    public void setDay(boolean day) {
        this.day = false;
    }
}
