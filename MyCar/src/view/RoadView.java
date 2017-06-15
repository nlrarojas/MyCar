package view;

import controller.RoadController;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import util.IConstants;

public class RoadView extends JPanel implements IConstants, Observer{

    public RoadView() {
        super();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(null);
        this.setOpaque(false);
    }    

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof RoadController){
            try {
                RoadController Road = (RoadController) o;
                this.getGraphics().drawImage(ImageIO.read(new File("C:\\Users\\Nelson\\Documents\\NetBeansProjects\\MyCar\\MyCar\\src\\assets\\calle" + Road.getImageId() + ".png")), 0, 0, null);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}