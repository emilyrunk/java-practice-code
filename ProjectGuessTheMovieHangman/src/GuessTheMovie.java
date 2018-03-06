import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GuessTheMovie {

    private char[] gameboard;
    private char[] movieToGuess;
    private int remainingGuesses = 10;
    private int underscoresLeft = 0;


    /*
    Initializes a movie picked from the list of movies and a blank gameboard that reflects the movie's
    letter order and spaces
     */
    public void init() throws Exception{

        movieToGuess = computerPicksMovie();

        gameboard = new char[movieToGuess.length];
        for (int i = 0; i < movieToGuess.length; i++) {
            if (movieToGuess[i]== ' '){
                gameboard[i] = ' ';
            } else {
                gameboard[i] = '_';
                underscoresLeft++;
            }
        }


    }

    /*
    Starts the game!
     */
    public void startGame() throws Exception{
        init();
        printInitial();

        while (!gameOver()) {
            runTurn();
        }

    }

    public void runTurn(){

        char userGuess = receiveUserGuess();
        checkGuess(userGuess);


        System.out.println(ctos(gameboard));
    }

    public boolean gameOver() {
        if(remainingGuesses == 0) {
            System.out.println("Game over because remaining guesses = 0");

            return true;
        }
        if(underscoresLeft == 0){
            System.out.println("Game over because underscores left = 0");
            return true;
        }
        return false;
    }


    public void printInitial() {
        System.out.println("Guess the movie!");

        System.out.println(movieToGuess);

        //Convert char[] into String so you can print it
//        stringBlanks = new String(gameboard);
        System.out.printf("You are guessing : %s \n", ctos(gameboard));
    }

    public static String ctos(char[] c){
        return new String(c);
    }

    public void checkGuess(char ug) {
        int tempUnderscoresLeft = 0;
        //Check if guessed letter is in movie name, change underscores to correct letter guessed
        for (int i = 0; i < movieToGuess.length ; i++){
            if (ug == movieToGuess[i]){
                gameboard[i] = ug;

            } else if (gameboard[i]=='_'){
                tempUnderscoresLeft++;
            }
        }
        if(tempUnderscoresLeft == underscoresLeft) {
            remainingGuesses--;
        }
        underscoresLeft = tempUnderscoresLeft;
    }

    public char receiveUserGuess() {
        //User input is here
        System.out.printf("Guess a letter: (You have %d tries left)\n",remainingGuesses);
        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextLine().charAt(0);
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

        return listOfMovies[random].toCharArray();

    }


}
