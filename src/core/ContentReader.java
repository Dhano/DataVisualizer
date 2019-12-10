package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ContentReader {

    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

    public  ArrayList<String> getChannels(){
        //System.out.println(new File("contents.txt").toPath());
//        try {
//            String[] array= (String[]) Files.readAllLines(new File("contents.txt").toPath()).toArray();
//            System.out.println(array);
//        }catch (IOException io){
//            io.printStackTrace();
//        }
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\ADMIN\\IdeaProjects\\AQI\\src\\core\\contents.txt")))) {
            while (br.ready()) {
                result.add(br.readLine());
            }

            System.out.println(result);
        }catch (IOException io){
            io.printStackTrace();
       }
        return result;


    }
    public String[] getDataTypes(){
        try {
            Files.readAllLines(Path.of("..\\data\\channels\\contents.txt"));
        }catch (IOException io){
            io.printStackTrace();
        }
        return cars;
    }
    public String[] getMessageTypes(){

        try {
            Files.readAllLines(Path.of("..\\data\\channels\\contents.txt"));
        }catch (IOException io){
            io.printStackTrace();
        }
        return cars;
    }
    public String[] getMessageMappings(){
        try {
            Files.readAllLines(Path.of("..\\data\\channels\\contents.txt"));
        }catch (IOException io){
            io.printStackTrace();
        }
        return cars;
    }

}
