package view;

import controller.RoadController;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import util.IConstants;

public class RoadView implements IConstants, Observer{

    private JLabel RoadBackGround;
    
    public RoadView(JLabel pRoadBackGround) {
        this.RoadBackGround = pRoadBackGround;
        initComponents();
    }

    private void initComponents() {
        RoadBackGround.setLayout(null);
    }    

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof RoadController){
            try {
                RoadController Road = (RoadController) o;                
                RoadBackGround.setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\Nelson\\Documents\\NetBeansProjects\\MyCar\\MyCar\\src\\assets\\calle" + Road.getImageId() + ".png"))));
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}