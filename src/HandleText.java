public class HandleText {

    //Räkna raderna (ej raden STOP)
    // Räkna antal tecken (ej ordet STOP)
    // Räkna antal ord (ej ordet STOP)
    //Ha koll på det längsta ordet (ej ordet STOP)
    //Har koll på om användaren har skrivit ordet stop eller inte

    private String text;
    private int rows;
    private int chars;
    private int words;
    private String longestWord;

    public HandleText(String inputString) {
        text=inputString;
    }
}
