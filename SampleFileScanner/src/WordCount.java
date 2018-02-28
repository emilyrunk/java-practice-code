import java.util.Scanner;
import java.io.File;

public class WordCount {
    public static void main(String [] args) throws Exception {
        //File object with name of file
        File file = new File("prideandprejudice.txt");

        //Pass file object into Scanner instead of System.in
        Scanner scanner = new Scanner(file);

        int words = 0;
        //Read the file line by line
        while(scanner.hasNextLine()) {
            //Stores each line
            String line = scanner.nextLine();
            //Split the line by spaces in each line to get individual words in an array
            //add them to the words variable
            words += line.split(" ").length;
        }
        System.out.println("This file contains " + words + " words.");

    }
}
