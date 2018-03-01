import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {


    public static void main(String[]args) throws Exception{

        System.out.println("Guess the movie!");

        char[] wrongGuesses = new char[10];
        int numberOfWrongGuesses = 0;
        String movieToGuess = computerPicksMovie();

        int length = movieToGuess.length();

        char blanks[] = new char[length];
        for (int i = 0; i < length; i++) {
            blanks[i] = '_';
        }

        System.out.println("You are guessing : " + blanks);

        Scanner inputScanner = new Scanner(System.in);


        while (numberOfWrongGuesses < 10) {
            String wrongGuessesString = new String(wrongGuesses);
            System.out.println("You have guessed (" + numberOfWrongGuesses + ") wrong letters: " + wrongGuessesString);
            System.out.println("Guess a letter: ");
            String userGuess = inputScanner.ne;
            //Guess a letter correctly
            if (movieToGuess.contains(userGuess)) {
                for (int i = 0; i < movieToGuess.length() ; i++) {
                    if (movieToGuess.charAt(i) == userGuess)
                }
            }
            //Guess a wrong letter
            numberOfWrongGuesses++;
        }


    }


    private static String computerPicksMovie() throws FileNotFoundException {

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

        String randomMovie = listOfMovies[random];
        System.out.println(randomMovie);

        return randomMovie;

    }

}
