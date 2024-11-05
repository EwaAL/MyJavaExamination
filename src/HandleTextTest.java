import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//*********************************************************************************
public class HandleTextTest {

    /*
     Denna klass testar:
     - om ordet stop kan läsas ut; boolean
     - om beräkningen av antalet rader blir korrekt; int
     - om beräkningen av antalet ord blir korrekt; int
     - om beräkningen av antalet tecken blir korrekt; int
     - om längsta ordet/orden plockas ut; String
    */


    //********************************************************************************
    @Test
    public void testGetAmountOfRows() {
        /*
         - Testar att beräkningen av antalet rader blir korrekt
         - Om en rad enbart består av ordet "stop" ska raden inte räknas
         - Om ordet "stop" finns i en rad med andra ord före ordet "stop" ska raden räknas
         - Om raden börjar med ordet "stop" och det kommer ord efter ska raden inte räknas
        */

        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine("Jag testar");
        myTextHandler.readLine("att skriva");
        myTextHandler.readLine("en massa ord");
        myTextHandler.readLine("stop och lite till");

        assertEquals(3, myTextHandler.getAmountOfRows());
    }

    //************************************************************************************
    @Test
    public void testGetAmountOfWords() {
        /*
         - Testar att beräkningen av antal ord blir korrekt
         - Ord före stopp-ordet ska räknas men inte ord efter stopp-ordet
         - Om texten börjar med stoppordet ska expected sättas till 0
        */

        String inputString = "Jag testar att skriva en massa ord stop och lite till";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals(7, myTextHandler.getAmountOfWords());
    }

    //************************************************************************************
    @Test
    public void testAmountOfChars() {
        /*
         - Testar att beräkningen av antal tecken blir korrekt
         - Om ett stopp-ord finns med ska enbart tecknen före stopp-ordet räknas
         - Texten kommer att trimmas så att eventuella blanksteg före första ordet och efter
           sista ordet i texten försvinner. Dessa ska alltså inte räknas med i expected.
        */

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals(34, myTextHandler.getAmountOfChars());
    }

    //********************************************************************************
    @Test
    public void testLongestWord() {
        /*
         - Testar att det går att ta ut det längsta ordet/orden från texten.
         - Enbart ord före eventuellt stopp-ord tas med i urvalet
         - Det görs ingen kontroll av stor och liten första-bokstav
           förutom för stopp-ordet. Expected måste alltså vara exakt i samma
           format som i test-meningen.
        */

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();
        myTextHandler.readLine(inputString);

        assertEquals("testar skriva", myTextHandler.getLongestWord());
    }

    //*******************************************************************************
    @Test
    public void testStopWord() {
        /*
        testar om ordet "stop" finns i texten
        det går att byta ut ordet "stop" till "stopp", "Stop" eller "Stopp"
        */

        String inputString = "Jag testar att skriva en massa ord stop";
        HandleText myTextHandler = new HandleText();

        assertEquals(true,myTextHandler.readLine(inputString));
    }
    //*********************************************************************************
}