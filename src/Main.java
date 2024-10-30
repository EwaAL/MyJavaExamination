import java.util.Scanner;

public class Main {
    //Skriv ett program som läser in text ifrån kommandoraden rad för rad
    // tills användaren skriver ordet stop.
    //När användaren är klar skriver programmet ut antal tecken
    // och hur många rader som användaren har skrivit,
    // exklusive raden med ordet stop.

    //En klass som läser in text och skriver ut resultatet till användaren.
    //Skriver ut antal ord (separerade med blanksteg).
    //Skriver ut det längsta ordet.
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);
        HandleText myTextHandler = new HandleText();

        do{
            System.out.println("Skriv din text här: ");
            myTextHandler.readLine(myScan.nextLine());
        }while(!myTextHandler.getStopNow());

        System.out.println("Du har skrivit " + myTextHandler.getAmountOfRows() + " antal rader");
        System.out.println("Du har skrivit " + myTextHandler.getAmountOfWords() + " antal ord");
        System.out.println("Texten består av " + myTextHandler.getAmountOfChars() + " antal tecken");
        System.out.println("Orden du har skrivit är: " + myTextHandler.getText());
        System.out.println("Det längsta ordet är: " + myTextHandler.getLongestWord());
    }
}