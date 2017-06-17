package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.RoadView;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import util.IConstants;

public class ThreadController extends Thread implements IConstants{

    private RoadView RoadPanelView;
    private RoadController Road;
    
    private static ThreadController threadControl = null;
    ExecutorService Executor = Executors.newFixedThreadPool(MAX_THREADS);
    
    public ThreadController() {
        
    }
    
    public static ThreadController getInstance(){
        if (threadControl == null){
            threadControl = new ThreadController();
        }        
        return threadControl; 
    }//Asi solo se instancia una unica vez
    
    public void addTaskToExecutor(Runnable pTask){
        Executor.execute(pTask);
    }
    
    public ExecutorService getExecutor(){
        return Executor;
    }

    public ThreadController(RoadView pRoadPanelView, int pFramesImage) {
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
                else
                    i = 100;
                Road.flipImage();                                
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
