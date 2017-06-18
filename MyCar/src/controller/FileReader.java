package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    private String text;
    private java.io.FileReader FileToRead;
    private BufferedReader br;
    
    public FileReader() {
        text = "";
    }
    
    public void readText(String direction){        
        try {
            FileToRead = new java.io.FileReader(direction);
            br = new BufferedReader(FileToRead);
            String line;
            while ((line = br.readLine()) != null){
                text = text + line;
            }            
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
