/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class MaxSpeed extends Obstacle{

    private int speedLimit;
    
    MaxSpeed(String pSpeedLimit) {
        this.speedLimit = Integer.parseInt(pSpeedLimit);
    }
    
    @Override
    public void generate(boolean b){
        
    }

    @Override
    public void generate() {
        
    }
}
