import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GuessTheMovie {

    private char[] gameboard;
    private char[] movieToGuess;
    private int underscoresLeft = 0;
    private String wrongLetters = "";
    private int numberOfWrongGuesses = 0;


    /*
    Starts the game!
     */
    public void startGame() throws Exception{
        init();
        printStartMessage();

        while (!gameOver()) {
            runTurn();
        }

    }




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
    Prints out the initial welcome message
     */

    public void printStartMessage() {
        System.out.println("Guess the movie!");

        System.out.println(movieToGuess);

        System.out.printf("You are guessing : %s \n", ctos(gameboard));
    }
    /*
    Defines the game-ending conditions, defaults to false. If it hits either of the 2 ending conditions,
    gameOver is set to true
     */

    public boolean gameOver() {
        if(numberOfWrongGuesses == 10) {
            System.out.println("Game over because remaining guesses = 0");

            return true;
        }
        if(underscoresLeft == 0){
            System.out.println("Game over because underscores left = 0");
            return true;
        }
        return false;
    }

    public void runTurn(){

        System.out.println("You have guessed (" + numberOfWrongGuesses + ") wrong letters: " + wrongLetters);
        char userGuess = receiveUserGuess();
        checkGuess(userGuess);

        System.out.println(ctos(gameboard));
    }


    public void checkGuess(char ug) {
        int tempUnderscoresLeft = 0;
        //Check if guessed letter is in movie name, change underscores to correct letter guessed
        //GUESS CORRECTLY
        for (int i = 0; i < movieToGuess.length ; i++){
            if (ug == movieToGuess[i]){
                gameboard[i] = ug;
            } else if (gameboard[i]=='_'){
                tempUnderscoresLeft++;
            }
        }
        if(tempUnderscoresLeft == underscoresLeft) {
            //WRONG GUESS
            wrongLetters += ug;
            numberOfWrongGuesses++;
        }

        underscoresLeft = tempUnderscoresLeft;
    }

    public char receiveUserGuess() {
        //User input is here
        System.out.println("Guess a letter:");
        Scanner inputScanner = new Scanner(System.in);
        char userInput = inputScanner.nextLine().charAt(0);
        while (!Character.isLetter(userInput)) {
            System.out.println("Your guess is invalid. Try again: ");
            userInput = inputScanner.nextLine().charAt(0);
        }
        return userInput;
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


    /*
    Converts char Array into String
     */

    public static String ctos(char[] c){
        return new String(c);
    }

}
