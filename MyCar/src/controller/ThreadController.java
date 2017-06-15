package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.RoadView;

public class ThreadController extends Thread{

    private RoadView RoadPanelView;
    private RoadController Road;
    
    public ThreadController() {

    }

    ThreadController(RoadView pRoadPanelView, int pFramesImage) {
        RoadPanelView = pRoadPanelView;
        Road = new RoadController(pFramesImage);
        Road.addObserver(RoadPanelView);
    }
    
    @Override
    public void run(){
        int i = 200;
        while(true){            
            try {
                if(i > 60)
                    i--;
                Road.flipImage();                                
                this.sleep(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}