
package JavaExaminationMorseCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//*************************************************************
// Denna klass är till för att utföra tester med junit.

public class TestMorseCode {
    LogicMorseCode myObj = new LogicMorseCode();
    ValidSigns myData = new ValidSigns();
//**************************************************************
    @Test
    public void testHandleInput(){
        assertTrue(myObj.handleInput("Testing"));
    }
//**************************************************************
    @Test
    public void testValidLetter(){
        assertFalse(myData.validLetter('?'));
    }
//**************************************************************
    @Test
    public void testPrintOut(){
        // testa att det går att skriva till prompten
        assertTrue(myObj.printOut(12));
    }
//**************************************************************
    @Test
    public void testGetChar(){
        myData.Init();
        char c = myData.getChar("...");
        assertEquals('S', c);
    }
//**************************************************************
    @Test
    public void testGetMorseCode(){
        myData.Init();
        String morse = myData.getMorseCode('S');
        assertEquals("...",morse)  ;
    }
}
