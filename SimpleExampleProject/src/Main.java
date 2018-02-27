import java.util.Scanner;
public class Main {

    public static void main(String [] args){
        System.out.println("Hello world!");

        //Practice Input Scanner Function Calls
        //String as input
        stringInputScannerExample();

        //Integer as input
        integerInputScannerExample();
    }


    //********* Practice Input Scanner Example *********
    //String input
    private static void stringInputScannerExample() {
        System.out.println("Enter your address: ");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        System.out.println("You live at: " + address);
    }

    //Integer input
    private static void integerInputScannerExample() {

        System.out.println("Enter your grade: ");
        Scanner scanner2 = new Scanner(System.in);
        int grade = scanner2.nextInt();
        if(grade > 90){
            System.out.println("Wow! You did well!");
        }else if (grade < 90 && grade > 70){
            System.out.println("Not bad, but you can do better next time!");
        } else {
            System.out.println("You should probably study harder.");
        }
    }

}
