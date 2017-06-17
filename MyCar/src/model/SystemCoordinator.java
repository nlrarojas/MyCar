package model;

import util.IConstants;

public class SystemCoordinator implements ISystem, IConstants{

    public SystemCoordinator() {
        
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
}