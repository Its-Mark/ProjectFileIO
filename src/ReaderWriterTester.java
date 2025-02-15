/**
 * Project File IO
 * @author Mark Garcia 018019103
 *         mark.garcia01@student.csulb.edu
 * @author Brandon Wiitanen
 *         brandon.wiitanen@student.csulb.edu
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * This tester randomly creates 40 new entries into the sales.txt file every time the program is ran.
 * It then sorts the entries, then writes the entries into the appropriate file (Lodging.txt, Dinner.txt, Conference.txt).
 * Amount of entries can be altered by adding more names into the names Array.
 * Variety of Dates can also be altered by adding more dates into the dates Array.
 */

public class ReaderWriterTester {
    public static void main(String[] args){
        //random names
        String[] names = {"Eve Goodwin", "Maliyah Fitzpatrick", "Carolina Holder", "Saige Golden", "Helen Lin", "Damon Harvey", "Reuben Cuevas", "Lizeth Bird", "Keon Garcia", "Jenny Baker", "Jadyn Snow", "Kaylyn Hall", "Peter Paul" ,"Amya Arnold","Natalee Stout", "Darrell Murillo","Tyshawn Patel", "Cara Mccormick", "Trace Ortega", "Kyle Brady",
                "Brynlee Suarez", "Eliza Marshall", "Abril Mcbride", "Landyn Garrison", "Ronin Larsen", "Kaleigh Valenzuela", "Albert Bray", "Harley Branch", "Demarcus Henry", "Ashleigh Mejia", "Rigoberto Chandler", "Emilia Wyatt", "Kaydence Ware", "Adriana Cain", "Houston Clements", "Kiley Rivera", "Turner York", "Zoe Mack", "Dominick Archer", "Ryann Burns"};
        //List of services
        String[] service = {"Dinner", "Lodging", "Conference"};
        //random dates
        String[] dates = {"4/20/2020", "1/15/2020", "2/15/2020", "9/19/2020", "10/30/2020", "11/11/2020", "5/15/2020", "10/11/2020",
                "1/1/2020", "12/25/2020", "6/4/2020"};
        String salesLine;
        try {
            FileWriter fw = new FileWriter("sales.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < names.length; i++) {
                int randService = (int)(Math.random() * (service.length));
                int randDate = (int)(Math.random() * (dates.length));
                double randCost = Math.random() * 500;
                salesLine = names[i] + ";" + service[randService] + ";" + String.format("%.2f",randCost) + ";" + dates[randDate] + "\n";
                bw.write(salesLine);
            } // end for loop to create sales file
            bw.close();
            fw.close();
            ReaderWriter rw = new ReaderWriter("sales.txt");
            rw.addLines();
            rw.sortLines();
            File cF = new File("Conference.txt");
            File dF = new File("Dinner.txt");
            File lF = new File("Lodging.txt");
            rw.writeToFile(lF,"lodging");
            rw.writeToFile(dF, "dinner");
            rw.writeToFile(cF, "conference");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
