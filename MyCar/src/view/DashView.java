package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.IConstants;

public class DashView extends JFrame implements IConstants, ActionListener{

    private JDesktopPane DesktopPane;
    private RoadView RoadPanelView;
    private JMenuBar MenuBar;
    private JMenu Menu;
    private JMenuItem ItemOpenFile;
    
    public DashView() {
        super("MyCar");
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
        this.setLocationRelativeTo(null);
        
        this.DesktopPane = new JDesktopPane();
        
        this.RoadPanelView = new RoadView();
        
        this.MenuBar = new JMenuBar();
        this.Menu = new JMenu("Archivo");        
        this.MenuBar.add(this.Menu).setBounds(0, 0, 100, 25);        
        this.ItemOpenFile = new JMenuItem("Abrir archivo");       
        this.Menu.add(ItemOpenFile).setBounds(0, 0, 100, 25);
        this.ItemOpenFile.addActionListener(this);              
        
        this.DesktopPane.add(this.MenuBar).setBounds(0, 0, WIDTH_WINDOW, 25);
        this.DesktopPane.add(this.RoadPanelView).setBounds(162, 100, 2 * WIDTH_WINDOW / 3, 2 * HEIGHT_WINDOW / 3);
        this.getContentPane().add(DesktopPane).setBounds(0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.ItemOpenFile){
            OpenFile();
        }
    }
    
    private void OpenFile(){
        JFileChooser FileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MyCar format", "mc");
        FileChooser.setFileFilter(filter);
        int returnVal = FileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + FileChooser.getSelectedFile().getName());
        }
    }
}