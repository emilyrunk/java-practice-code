import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {


    public static void main(String[]args) throws Exception{

        String wrongGuesses = "";
        int numberOfWrongGuesses = 0;
        char[] movieToGuess = computerPicksMovie();
        int length = movieToGuess.length;


        System.out.println("Guess the movie!");

        System.out.println(movieToGuess);

        //Create word showing only underscores
        char blanks[] = new char[length];
        for (int i = 0; i < length; i++) {
            blanks[i] = '_';
        }
        //Convert char[] into String so you can print it
        String stringBlanks = new String(blanks);
        System.out.println("You are guessing : " + stringBlanks);

        System.out.println("Guess a letter: ");

        //User input is here
        Scanner inputScanner = new Scanner(System.in);
        char userGuess = inputScanner.nextLine().charAt(0);

        for (int i = 0; i < length ; i++){
            if (userGuess == movieToGuess[i]){
                blanks[i] = userGuess;
            } else {
                blanks[i] = '_';
            }
        }

        stringBlanks = new String(blanks);

        System.out.println(stringBlanks);
        


    }


    private static char[] computerPicksMovie() throws FileNotFoundException {

        int movieIndex = 0;
        String [] listOfMovies = new String[500];

        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()) {
            String movie = scanner.nextLine();
            listOfMovies[movieIndex] = movie;
            movieIndex++;
        }
        int random = (int) (Math.random() * movieIndex) + 1;

        char[] randomMovie = listOfMovies[random].toCharArray();

        return randomMovie;

    }

}
