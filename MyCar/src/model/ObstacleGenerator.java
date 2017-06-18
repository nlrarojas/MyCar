package model;

public class ObstacleGenerator {
    public boolean isDay;

    public ObstacleGenerator() {
        isDay = true;
    }
    
    
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
                isDay = true;
                return new Day();
            case "N":
                isDay = false;
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


