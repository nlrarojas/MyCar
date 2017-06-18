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
import model.Obstacle;
import util.IConstants;

public class RoadView implements IConstants, Observer{

    private JLabel RoadBackGround;
    private RoadController obstacles;
    
    public RoadView(JLabel pRoadBackGround) {
        super();
        this.obstacles = new RoadController();
        obstacles.getRoad();
        this.RoadBackGround = pRoadBackGround;
        initComponents();
    }

    private void initComponents() {
        RoadBackGround.setLayout(null);
        
        //RoadPanel.setOpaque(false);
    }    

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof RoadController){
            try {
                RoadController Road = (RoadController) o;                
                RoadBackGround.setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\Nelson\\Documents\\NetBeansProjects\\MyCar\\MyCar\\src\\assets\\calle" + Road.getImageId() + ".png"))));
                //RoadBackGround.getGraphics().drawImage(ImageIO.read(new File("C:\\Users\\Nelson\\Documents\\NetBeansProjects\\MyCar\\MyCar\\src\\assets\\calle" + Road.getImageId() + ".png")), 0, 0, null);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    public void paint(int number){
        //Aquí debería agarrar uno a uno los obtaculos
        Obstacle actual;
        actual = obstacles.getActualObstacle();
        actual.generate();
        try {
            this.RoadBackGround.setIcon(new ImageIcon(ImageIO.read(new File(actual.getPath() + number + ".png"))));
        } catch (IOException ex) {
            Logger.getLogger(RoadView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Thread thread = new Thread(){
        public void run(){
            for (int i = 0; i<100; i++){
                paint(i);
            }
        }
    };
}