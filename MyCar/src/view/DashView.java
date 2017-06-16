package view;

import controller.DashController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.IConstants;

public class DashView extends JFrame implements IConstants, ActionListener, Observer, KeyListener{

    private DashController Controller;
    private RoadView RoadPanelView;
    
    private JDesktopPane DesktopPane;
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
        this.DesktopPane.add(this.RoadPanelView).setBounds(256, 190, 512, 380);
        this.getContentPane().add(DesktopPane).setBounds(0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
        
        this.addKeyListener(this);
        
        controllerManager();
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
            System.out.println("You chose to open this file: " + FileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
    
    private void controllerManager(){
        this.Controller = new DashController(RoadPanelView, 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            System.out.println("Direccional Izquierda");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("Bajar marcha");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            System.out.println("Direccional Derecha");            
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("Subir marcha");
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Enciende Apaga Luz");
        }                
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("Izquierda");
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("Derecha");
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("Acelerar");
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("Frenar");
        }        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}