package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import util.IConstants;

public class RoadView extends JPanel implements IConstants, Observer{

    public RoadView() {
        super();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(null);
        this.setBackground(Color.red);
        
    }    

    @Override
    public void update(Observable o, Object arg) {
        
    }
}