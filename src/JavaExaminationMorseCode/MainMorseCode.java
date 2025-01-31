package JavaExaminationMorseCode;

public class MainMorseCode {
    //klass som läser in text och skriver ut text (med en
    //main-metod).
    public static void main(String[] args) {
        boolean printOK;

        LogicMorseCode myObj = new LogicMorseCode();
        String text = myObj.readText(false);
        printOK = myObj.printOut(text);
    }
}
