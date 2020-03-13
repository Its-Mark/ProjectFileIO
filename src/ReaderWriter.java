import java.io.FileNotFoundException;
import java.io.File;
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
    }

    /**
     * Overloaded constructor.
     * @param f = file chosen by user
     */
    public ReaderWriter(String f){
        this.file = new File(f);
        this.lines = new ArrayList<>();
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
     * Override toString method
     * @return a string saying what file is being worked on at the moment.
     */
    @Override
    public String toString(){
        return this.file.toString() + " is the current file";
    }

}
