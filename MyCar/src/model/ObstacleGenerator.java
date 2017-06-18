/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class ObstacleGenerator {
    public Obstacle generateObstacle(String obstacle){
        //Sé que queda feo por se codigo chorreado
        //Pero creo que solo asi se puede en este caso
        switch (obstacle){
            case ".":
                return new StraightStreet();
            case "T":
                return new Intersection();
            case "+":
                return new FourCorners();
            case "D":
                return new Day();
            case "N":
                return new Night();
            case "L":
                return new Rain();
            case "m":
                return new MinSpeed();
            case "M":
                return new MaxSpeed();
            case "F":
                return new Final();
        }
        return null;
    }
}
