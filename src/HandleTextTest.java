import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandleTextTest {
    //Skriv ett program som läser in text ifrån kommandoraden rad för rad
    // tills användaren skriver ordet stop.
    //När användaren är klar skriver programmet ut antal tecken
    // och hur många rader som användaren har skrivit,
    // exklusive raden med ordet stop.

    //Till programmet skall minst tre Junit-testfall skrivas
    //Testfallen skall skilja sig märkvärt åt och testa olika delar av programmet.
    //Programmet skall versionshanteras och finnas tillgängligt på Github.

    @Test
    public void testCharCount(){

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText(inputString);

        assertEquals(35,myTextHandler.charCount);
    }
    public void testRowCount(){

        int rows;
        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText(inputString);

        assertEquals(35,myTextHandler.charCount);

    }
    public void testLongestWord(){

        assertEquals(true, blnOK);
    }
    public void testWordsTotal(){

        assertEquals(true, blnOK);
    }
    public void testStopWord(){

        assertEquals(true, blnOK);
    }




}
