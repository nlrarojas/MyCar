package model;

public class ObstacleGenerator {
    public boolean isDay;

    public ObstacleGenerator() {
        isDay = true;
    }
    
    public Obstacle generateObstacle(String obstacle){        
        //Sé que queda feo por se codigo chorreado
        //Pero creo que solo asi se puede en este caso
        switch (obstacle.substring(0, 1)){
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
                return new MinSpeed(obstacle.substring(1));
            case "M":
                return new MaxSpeed(obstacle.substring(1));
            case "F":
                return new Final();
        }        
        return null;
    }
}


