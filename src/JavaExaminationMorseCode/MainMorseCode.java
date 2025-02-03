// Detta program gör om morsekod till engelska
// och engelska till morsekod
//*******************************************************************
package JavaExaminationMorseCode;

//*******************************************************************
public class MainMorseCode {
    // denna klass innehåller enbart en Main-metod som anropar
    // logik-klassen för all funktionalitet
    //******************************************************************
    public static void main(String[] args) {
        // - anropar logikklassen för att skriva ut meddelanden,
        //   läsa in användarens text och för att omvandla text
        //   till morse/bokstäver
        // - anropar logikklassen för att skriva ut omvandlad text
        // - om texten inte gick att omvandla får användaren ny chans

        LogicMorseCode myLogic = new LogicMorseCode();
        boolean newTry = false; // avgör om användaren vill skriva igen

        myLogic.welcome();// lite välkomstmeddelanden...
        try {
            do { // körs så länge användaren vill skriva in nåt nytt
                if (myLogic.handleInput("")) {
                    boolean test = myLogic.printOut(6); // siffrorna avgör meddelandetext
                } else {
                    boolean test = myLogic.printOut(2);
                }
                newTry = myLogic.tryAgain(5);// true = anv. vill skriva nåt igen
            } while (newTry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
