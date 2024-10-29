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
        //Testar funktionen som räknar antal tecken i strängen

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals(35,myTextHandler.charCount());
    }
    @Test
    public void testRowCount(){
        //Testar funktionen som kontrollerar antalet rader från inläsningen
        String inputString = "Jag testar att skriva en massa ord stop";
        int rows=2;
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine("Jag testar");
        myTextHandler.readLine("att skriva");
        myTextHandler.readLine("en massa ord");
        myTextHandler.readLine("stop");

        assertEquals(3,myTextHandler.rowCount());

    }
    @Test
    public void testLongestWord(){
        //Testar funktionen som ska hitta det längsta ordet.
        // Om flera ord är lika långa och är de längsta orden väljs
        // det första längsta ordet ut.

        String inputString = "Jag testar att skriva en massa ord stop";
        int rows=2;
        HandleText myTextHandler = new HandleText();

        assertEquals("testar", myTextHandler.getLongestWord());
    }
    @Test
    public void testWordsTotal(){

        //Testar funktionen som räknar antalet ord

        String inputString = "Jag testar att skriva en massa ord stop";
        int rows=2;
        HandleText myTextHandler = new HandleText();

        assertEquals(7, myTextHandler.wordsTotal());
    }
    @Test
    public void testStopWord(){

        //testar funktionen som ska upptäcka om ordet "stop" har skrivits

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();

        assertEquals(true,myTextHandler.readLine(inputString));
    }
}
