package com.revature.FileIO;

import java.io.*;

public class FileIO {

    public static final String filename = "src/main/resources/HighScores.txt";

    public FileIO() {}
    
    public void readScores() {
        try(FileReader fr = new FileReader(filename)) {
           //Read High Scores File
           int i;
           while ((i = fr.read()) != -1) {
           System.out.print((char) i);
           }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void writeScore(String name, short score) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(name + " " +score);
            bw.newLine();
            bw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}