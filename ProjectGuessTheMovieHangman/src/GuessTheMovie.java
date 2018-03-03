import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {


    public static void main(String[]args) throws Exception{

        String wrongLetters = "";
        int numberOfWrongGuesses = 0;
        char[] movieToGuess = computerPicksMovie();

        char underscores[] = new char[movieToGuess.length];
        for (int i = 0; i < movieToGuess.length; i++) {
            if (movieToGuess[i]== ' '){
                underscores[i] = ' ';
            } else {
                underscores[i] = '_';
            }
        }



        System.out.println("Guess the movie!");

        System.out.println(movieToGuess);

        String tempStringBlanks;


        //Convert char[] into String so you can print it
        String stringBlanks = new String(underscores);
        System.out.println("You are guessing : " + stringBlanks);



        //User input is here
        System.out.println("Guess a letter: ");
        Scanner inputScanner = new Scanner(System.in);
        char userGuess = inputScanner.nextLine().charAt(0);


        //Check if guessed letter is in movie name, change underscores to correct letter guessed
        for (int i = 0; i < movieToGuess.length ; i++){
            if (userGuess == movieToGuess[i]){
                underscores[i] = userGuess;
            }
        }
        tempStringBlanks = new String(underscores);


        //Check to see if new string is same as previous string (was the letter guess right or wrong?
        if (tempStringBlanks == stringBlanks){
            //wrong guess
            numberOfWrongGuesses++;
        } else {
            //right guess
            stringBlanks = tempStringBlanks;
        }

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
