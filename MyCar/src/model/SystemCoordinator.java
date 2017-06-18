package model;

import controller.Evaluator;
import util.IConstants;
import view.RoadView;

public class SystemCoordinator implements ISystem, IConstants{

    private Evaluator PlayerEvaluator;
    private RoadView RoadViewImplementation;
    
    public SystemCoordinator(RoadView pRoadView) {
        PlayerEvaluator = new Evaluator();
        RoadViewImplementation = pRoadView;
    }
    
    @Override
    public int removePoints(int pPoints){
        PlayerEvaluator.setScore(PlayerEvaluator.getScore() - pPoints);        
        return PlayerEvaluator.getScore();
    }

    @Override
    public String executeSystemInstruction(String  pInstuctionValue) {
        if(pInstuctionValue.equals(TURN_LEFT)){
            
        }            
        if(pInstuctionValue.equals(TURN_RIGTH)){
            
        }
        if(pInstuctionValue.equals(SPEED_UP_ENGINE)){
            
        }
        if(pInstuctionValue.equals(SLOW_DOWN_ENGINE)){
            
        }
        if(pInstuctionValue.equals(GEAR_UP)){
            
        }
        if(pInstuctionValue.equals(GEAR_DOWN)){
            
        }
        if(pInstuctionValue.equals(START_LIGTHS)){
            return START_LIGTHS;
        }
        if(pInstuctionValue.equals(SHUTDOWN_LIGTHS)){
            return SHUTDOWN_LIGTHS;
        }
        if(pInstuctionValue.equals(START_WINDSHIELD)){
            
        }
        if(pInstuctionValue.equals(STOP_WINDSHIELD)){
            
        }
        return NONE_INSTRUCTION;
    }
    
    @Override
    public void updateSpeed(int pSpeed){
        java.lang.System.out.println(pSpeed);
        ROAD.setFrameSpeed(pSpeed);        
    }
    
    @Override
    public void startSimulation(String pFileRoadPath){
        if(!THREADS.isThreadStarted()){
            ROAD.setFilePath(pFileRoadPath);
            ROAD.addObserver(RoadViewImplementation);
            THREADS.addTaskToExecutor(ROAD);
            THREADS.start();
            THREADS.setThreadStarted(true);
        }
    } 
}