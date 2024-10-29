import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//*********************************************************************************
public class HandleTextTest {

    //Denna klass testar:
    // - om ordet stop kan läsas ut; boolean
    // - om beräkningen av antalet rader blir korrekt; int
    // - om beräkningen av antalet ord blir korrekt; int
    // - om beräkningen av antalet tecken blir korrekt; int
    // - om längsta ordet plockas ut; String

    //*********************************************************************************
    @Test
    public void testStopWord() {
        //testar om ordet "stop" finns i texten
        //det går att byta ut ordet "stop" till "stopp", "Stop" eller "Stopp"

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();

        assertTrue(myTextHandler.readLine(inputString));
    }

    //********************************************************************************
    @Test
    public void testRowCount() {
        // Testar att beräkningen av antalet rader blir korrekt
        // Om en rad enbart består av ordet "stop" ska raden inte räknas
        // Om ordet "stop" finns i en rad med andra ord före ordet "stop" ska raden räknas
        // Om raden börjar med ordet "stop" och det kommer ord efter ska raden inte räknas

        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine("Jag testar");
        myTextHandler.readLine("att skriva");
        myTextHandler.readLine("en massa ord");
        myTextHandler.readLine("stop och lite till");

        assertEquals(3, myTextHandler.rowCount());
    }

    //************************************************************************************
    @Test
    public void testWordsTotal() {

        // Testar att beräkningen av antal ord blir korrekt
        // Ord före stopp-ordet ska räknas men inte ord efter stopp-ordet
        // Om texten börjar med stoppordet ska expected sättas till 0

        String inputString = "Jag testar att skriva en massa ord stop och lite till";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals(7, myTextHandler.wordsTotal());
    }

    //************************************************************************************
    @Test
    public void testCharCount() {
        // Testar att beräkningen av antal tecken blir korrekt
        // Om ett stopp-ord finns med ska enbart tecknen före stopp-ordet
        // räknas
        // Texten kommer att trimmas så att eventuella blanksteg före första ordet och efter
        // sista ordet i texten försvinner. Dessa ska alltså inte räknas med i expected.

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals(34, myTextHandler.charCount());
    }

    //********************************************************************************
    @Test
    public void testLongestWord() {
        // Testar att det går att ta ut det längsta ordet från texten.
        // Om flera ord är lika långa och dessa ord är de längsta orden väljs
        // det första av de längsta orden ut.
        // Enbart ord före eventuellt stopp-ord tas med i urvalet
        // Det görs ingen kontroll av stor och liten första-bokstav
        // förutom för stopp-ordet. Expected måste alltså vara exakt i samma
        // format som i test-meningen.

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals("testar", myTextHandler.getLongestWord());
    }
//*******************************************************************************
}
