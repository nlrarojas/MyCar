package controller;

import view.RoadView;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import util.IConstants;

public class ThreadController extends Thread implements IConstants{

    private RoadView RoadPanelView;
    private RoadController Road;
    
    private static ThreadController threadControl = null;
    private static ExecutorService Executor;
    
    public ThreadController() {
        
    }
    
    public static ThreadController getInstance(){
        if (threadControl == null){
            threadControl = new ThreadController();
            Executor = Executors.newFixedThreadPool(MAX_THREADS);
        }        
        return threadControl; 
    }//Asi solo se instancia una unica vez
    
    public void addTaskToExecutor(Runnable pTask){
        Executor.execute(pTask);
    }
    
    public ExecutorService getExecutor(){
        return Executor;
    }
}
