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
    private boolean stop = false;

    public HandleText(String inputString) {
        text = inputString;
        this.rows = rows;
    }

    public int charCount() {

        return chars;
    }

    public int rowCount() {

        return rows;
    }

    public String getLongestWord() {

        int length=0;
        String[] wordArray = text.split(" ");
        for (int i = 0; i < wordArray.length; i++){
            if (length<wordArray[i].chars().sum()){
                length=wordArray[i].chars().sum();
                longestWord=wordArray[i];
            }
        }
        return longestWord;
    }

    public int wordsTotal() {

        String[] wordArray = text.split(" ");
        if (stop == true) {
            words = wordArray.length - 1;
        } else {
            words = wordArray.length;
        }
        return words;
    }

    public boolean stopWord() {

        if (text.contains("stop")) {
            stop = true;
        }
        return stop;
    }
}
