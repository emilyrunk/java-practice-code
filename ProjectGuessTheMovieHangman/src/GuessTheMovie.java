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



    /*
    Checks to see if the user's guess is in the movie name, changing the underscores to include the user's guess,
    and counting up the number of underscores. If the underscores does not change from before the user's guess, means
    the user guess was wrong. In this case, add to number of wrong guesses, and add the user's guess to the list
    of letters guessed incorrectly.
     */
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


    /*
    With the user's guess, make make sure it is a letter (not symbol, space or number).
    If it's not a letter, prompt the user to input it again, printing out an error message.
     */
    public char receiveUserGuess() {

        System.out.println("Guess a letter:");
        char userChar;
        while (true) {
            userChar = getUserChar();
            if (Character.isLetter(userChar)) {
                break;
            }
            guessErrorMessage();
        }

        return userChar;
    }

    /*
    Calls for the user's guess, making sure it's not empty, returning a character
     */
    private static char getUserChar() {
        Scanner inputScanner = new Scanner(System.in);
        char userInput = 13;
        String nextLine = inputScanner.nextLine();
        if(!nextLine.isEmpty()) {
            userInput = nextLine.charAt(0);
        }
        return userInput;
    }

    private static void guessErrorMessage(){
        System.out.println("Your guess is invalid. Try again: ");
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
