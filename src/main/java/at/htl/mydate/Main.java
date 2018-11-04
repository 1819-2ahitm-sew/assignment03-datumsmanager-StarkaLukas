package at.htl.mydate;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    // 2018-04-11-HM: funktioniert abgesehen von Exception am Programmende (siehe Kommentar in MyDate.java)
    public static void main(String[] args) {

        int dateNumber = 1;
        String input = "";
        MyDate myDate; // 2018-04-11-HM: wird nie verwendet
        MyDate currentDate;
        MyDate correctDate; // 2018-04-11-HM: wird nie verwendet
        MyDate youngestDate = new MyDate("1.1.00");

        System.out.print("Date-Manager\n=========\n\n1. Datum: ");
        input = scanner.nextLine();

        while (!input.equals("quit")) {
            currentDate = new MyDate(input);

            if (currentDate.correctDate(input)) {
                dateNumber++;
                if (currentDate.isYoungerThan(youngestDate)) {
                    youngestDate = currentDate;
                }
                System.out.printf("Jüngstes Datum: %s%n",youngestDate.formatDate());
            }
            else {
                System.out.println("Ungültige Eingabe!");
            }

            System.out.printf("%d. Datum: ", dateNumber);
            input = scanner.nextLine();
        }


    }
}
