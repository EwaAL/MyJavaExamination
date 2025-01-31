
package JavaExaminationMorseCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMorseCode {
    //skriv minst 5 JUnit-testfall

    @Test
    public void testPrintOut(){
        // testa att det går att skriva till prompten
        String text = "Testing Printing Function";
        LogicMorseCode myObj = new LogicMorseCode();
        assertTrue(myObj.printOut(text));

    }

    @Test
    public void testReadText(){
       
    }

    @Test
    public void testSplitText(){
        //testa att det går att separera en String
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
