/**
 * Project File IO
 * @author Mark Garcia 018019103
 *         mark.garcia01@student.csulb.edu
 * @author Brandon Wiitanen
 *         brandon.wiitanen@student.csulb.edu
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ReaderWriter {
    private File file;
    private ArrayList<String> lines;
    private ArrayList<String> dinnerLines;
    private ArrayList<String> conferenceLines;
    private ArrayList<String> lodgeLines;

    /**
     * Default constructor.
     * Will never be used
     */
    public ReaderWriter(){
        this.file = null;
        this.lines = new ArrayList<>();
        this.dinnerLines = new ArrayList<>();
        this.conferenceLines = new ArrayList<>();
        this.lodgeLines = new ArrayList<>();
    }

    /**
     * Overloaded constructor.
     * @param f = file chosen by user
     */
    public ReaderWriter(String f){
        this.file = new File(f);
        this.lines = new ArrayList<>();
        this.dinnerLines = new ArrayList<>();
        this.conferenceLines = new ArrayList<>();
        this.lodgeLines = new ArrayList<>();
    }

    /**
     * Reads current file and adds all lines to an ArrayList (lines) .
     */
    public void addLines(){
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                lines.add(fileScanner.nextLine());
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    /**
     * Return lines ArrayList
     * @return this.lines
     */
    public ArrayList<String> getLines(){
        return this.lines;
    }

    /**
     * Return dinnerLines ArrayList
     * @return this.dinnerLines
     */
    public ArrayList<String> getDinnerLines(){
        return this.dinnerLines;
    }

    /**
     * Return conferenceLines ArrayList
     * @return this.conferenceLines
     */
    public ArrayList<String> getConferenceLines(){
        return this.conferenceLines;
    }

    /**
     * Return lodgeLines ArrayList
     * @return this.lodgeLines
     */
    public ArrayList<String> getLodgeLines(){
        return this.lodgeLines;
    }

    /**
     * Goes through lines and sorts lines into the correct array list
     */
    public void sortLines(){
        for (int i = 0; i < lines.size(); i++){
            String temp = lines.get(i).toLowerCase();
            if(temp.contains("dinner")){
                dinnerLines.add(lines.get(i));
            } else if (temp.contains("conference")){
                conferenceLines.add(lines.get(i));
            } else if (temp.contains("lodging")) {
                lodgeLines.add(lines.get(i));
            }
        }
    }


    public void writeLodgingFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < lodgeLines.size(); i++){
                bw.write(lodgeLines.get(i) + "\n");
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void writeConferenceFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < conferenceLines.size(); i++){
                bw.write(conferenceLines.get(i) + "\n");
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void writeDinnerFile(File f){
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < dinnerLines.size(); i++){
                bw.write(dinnerLines.get(i) + "\n");
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Override toString method
     * @return a string saying what file is being worked on at the moment.
     */
    @Override
    public String toString(){
        return this.file.toString() + " is the current file";
    }

}
