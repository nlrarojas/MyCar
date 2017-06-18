/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Intersection extends Obstacle{
    public void generate(boolean b){
        if (b){
            this.path = "src/images.carreteraDiaT/carreteraDiaT";
        }
        else{
            this.path = "src/images.carreteraNocheT/carreteraNocheT";
        }
    }
}
