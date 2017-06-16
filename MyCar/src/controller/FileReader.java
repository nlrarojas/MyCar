package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FileReader() {
        text = "";
    }
    public void readText(String direction){
        java.io.File file = new java.io.File(direction);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                String line = input.nextLine();
                text =text + line;
            }
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
}