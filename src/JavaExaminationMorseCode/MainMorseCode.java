// Detta program gör om morsekod till engelska
// och engelska till morsekod.
// Skrivet av Ewa Almkvist Lundberg januari 2025
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
        boolean newTry = false; // avgör om användaren vill
                                // prova igen

        myLogic.welcome();// lite välkomstmeddelanden...
        try {
            do { // låter logikklassen sköta allt
                if (myLogic.handleInput("")) {
                    // skriver ut omvandlad text
                    boolean test = myLogic.printOut(6);
                } else {
                    // skriver ut felmeddelande
                    boolean test = myLogic.printOut(2);
                }
                newTry = myLogic.tryAgain(5);// börjar om
            } while (newTry); // loopar tills användaren
                                // vill avsluta
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
