package controller;

import java.util.Observable;
import view.RoadView;

public class DashController extends Observable{

    private RoadView RoadPanelView;
    private ThreadController Threads;
    
    public DashController() {

    }

    public DashController(RoadView pRoadPanelView, int pFramesImage) {
        Threads = new ThreadController(pRoadPanelView, pFramesImage);
        Threads.start();
    }
}