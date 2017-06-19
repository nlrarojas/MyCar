package view;

import controller.RoadController;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.ObstacleGenerator;
import util.IConstants;

public class RoadView implements IConstants, Observer{

    private JLabel RoadBackGround;
    private ObstacleGenerator generator;
    
    public RoadView(JLabel pRoadBackGround) {
        this.RoadBackGround = pRoadBackGround;
        generator = new ObstacleGenerator();        
        initComponents();
    }

    private void initComponents() {
        RoadBackGround.setLayout(null);
    }    

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof RoadController){
            RoadController Road = (RoadController) o;
            if(Road.getActualObstacle() != null){
                try {
                    Road.getActualObstacle().generate();
                    RoadBackGround.setIcon(new ImageIcon(ImageIO.read(new File(Road.getActualObstacle().getPath()))));
                    //System.out.println(Road.getActualObstacle().getPath());
                } catch (IOException ex) {
                    Logger.getLogger(RoadView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(Road.getActualObstacle().getClass().equals(model.Final.class)){
                Road.setRunRoadController(false);
            }
        }
    }    
}
