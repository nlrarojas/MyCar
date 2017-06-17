package model;

public abstract class System implements Runnable{

    protected ISystem SystemController;
    protected String instruction;
    
    public System(ISystem pSystem) {
        this.SystemController = pSystem;
    }

    @Override
    public void run() {
        while (true){
            
        }
        //Verificar si la ejecución debe de hacerse aquí
    }
    
    public abstract void instructionToExecute(String pInstruction);
    
    
}