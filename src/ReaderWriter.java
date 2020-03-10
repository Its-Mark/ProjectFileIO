import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class ReaderWriter {
    private File file;
    private ArrayList<String> lines;

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

    public void addLines(){
        try {
            Scanner fileScanner = new Scanner(file);

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
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
