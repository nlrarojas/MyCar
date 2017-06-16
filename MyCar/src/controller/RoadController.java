package controller;

public class RoadController {
    
    FileReader document;
    String[] road;

    public RoadController() {
        document = new FileReader();
    }
    
    public String[] chargeRoad(){
        document.readText("C:\\Users\\Yelson\\Documents\\GitHub\\MyCar\\MyCar\\Road.txt"); 
        // Cualquier direccion, en estoy usando esta en este caso
        String text = this.document.getText();
        String[] list = text.split("");
        return list;
    }
    public String[] getRoad(){
        road = chargeRoad();
        return road;
    }
}