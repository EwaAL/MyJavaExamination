package JavaExaminationMorseCode;

public class MainMorseCode {
    //klass som läser in text och skriver ut text (med en
    //main-metod).
    public static void main(String[] args) {
        boolean printOK;
        LogicMorseCode myObj = new LogicMorseCode();

        // läs in text
        String text = myObj.readText();
       // TODO! lägg till koll att det finns text!
        myObj.setTextToUse(text);
        // dela upp tecknen i texten
        myObj.splitText(text);
        // kolla att texten endast innehåller godkända tecken
        boolean textOK = myObj.validText();
        // om texten är godkänd, ta reda på om det är bokstäver eller morsekod
        if (textOK) {
            int choice = myObj.isEngOrMorse(text);
            switch (choice) {
                case 1:
                    String morseCode = myObj.engToMorse();
                    break;
                case 2:
                    myObj.morseToEng();
                    break;
                default:
                    //vet inte vad som ska hända här
            }
        }
        printOK = myObj.printOut(text);
    }
}
