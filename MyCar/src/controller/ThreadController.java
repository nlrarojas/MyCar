package controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadController {
    private static ThreadController threadControl = null;
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    
    private ThreadController() {
    }
    //Asi solo se instancia una unica vez
    public static ThreadController getInstance(){
        if (threadControl == null){
            threadControl = new ThreadController();
        }
        return threadControl;
    }
    
    public ExecutorService getExecutor(){
        return executorService;
    }
}