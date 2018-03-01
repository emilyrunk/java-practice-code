import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String [] args) throws FileNotFoundException {

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

        int length = randomMovie.length();

        String underscores = "";
        for (int i = 0; i < length; i++) {
            underscores = underscores.concat("_");
        }
        System.out.println(underscores);
    }
}
