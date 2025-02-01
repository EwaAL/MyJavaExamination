
package JavaExaminationMorseCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMorseCode {
    //skriv minst 5 JUnit-testfall
    LogicMorseCode myObj = new LogicMorseCode();

    @Test
    public void testSplitText(){
        //testa att det går att separera en String
        myObj.splitText("Testing");
    }
    @Test
    public void testValidText(){
        //myObj.setTextToUse("Testing");
        myObj.splitText("Test123?!");
        boolean ok=myObj.validText();
        assertTrue(!ok);
    }

    @Test
    public void testPrintOut(){
        // testa att det går att skriva till prompten
        String text = "Testing Printing Function";
        assertTrue(myObj.printOut(text));

    }



    @Test
    public void testMorseToEng(){
        //testa att det går att omvandla från morse till engelska
    }

    @Test
    public void testEngToMorse(){
        //testa att det går att omvandla från engelska till morse
    }

}
