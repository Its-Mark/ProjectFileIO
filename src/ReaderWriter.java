import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ReaderWriter<E> {
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

    /**
     * Creates new file based on the service
     * Writes the data from correct ArrayList into that new file.
     * @param service = type of service to create the file
     */
    public void writeToFile(String service){
        if(service.toLowerCase() == "dinner" || service.toLowerCase() == "conference" || service.toLowerCase() == "lodging") {
            File fileToWrite = new File("C:\\Users\\milk8\\Desktop\\CECS 277\\Projects\\ProjectFileIO" + service);
            try {
                FileWriter fw = new FileWriter(fileToWrite);
                BufferedWriter bw = new BufferedWriter(fw);
                if (service.compareToIgnoreCase("dinner") == 0) {
                    for (int i = 0; i < dinnerLines.size(); i++) {
                        bw.write(dinnerLines.get(i));
                    }
                } else if (service.compareToIgnoreCase("lodging") == 0) {
                    for (int i = 0; i < lodgeLines.size(); i++) {
                        bw.write(lodgeLines.get(i));
                    }
                } else if (service.compareToIgnoreCase("conference") == 0) {
                    for (int i = 0; i < conferenceLines.size(); i++) {
                        bw.write(conferenceLines.get(i));
                    }
                }
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            System.out.println("Invalid service");
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
