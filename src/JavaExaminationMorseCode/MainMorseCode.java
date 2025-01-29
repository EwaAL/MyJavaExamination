package JavaExaminationMorseCode;

public class MainMorseCode {
    //klass som läser in text och skriver ut text (med en
    //main-metod).
    public static void main(String[] args) {

        LogicMorseCode myObj = new LogicMorseCode();
        String[] text = myObj.readFromPrompt();
        myObj.printToPrompt(text);
    }
}
