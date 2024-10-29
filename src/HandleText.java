public class HandleText {


    //Räkna raderna
    // Räkna antal tecken (ej ordet STOP)
    // Räkna antal ord (ej ordet STOP)
    //Ha koll på det längsta ordet (ej ordet STOP)
    //Har koll på om användaren har skrivit ordet stop eller inte

    private String text;
    private int rows;
    private int chars;
    private int words;
    private String longestWord;
    private boolean stop;

    public HandleText() {
        rows = 0;
        text = "";
        longestWord = "";
        chars = 0;
        words = 0;
        stop = false;
    }

    public boolean readLine(String inputString) {

        inputString = checkStopWord(inputString);

        text = text + inputString;
        rows++;

        return stop;

    }

    private String checkStopWord(String text) {
        String stopWord = "";
        //om texten endast består av ordet "stop" i någon form ska metoden returnera en tom string
        if (text.equals("stop") || text.equals("stopp") || text.equals("Stop") || text.equals("Stopp")) {
            stop = true;
            return "";
            //om texten innehåller ordet "stop" i någon form ska stopp-ordet och ev efterkommande text tas bort från texten
        } else if (text.contains("stop") || text.contains("stopp") || text.contains("Stop") || text.contains("Stopp")) {

            if (text.contains("stop")) {
                stopWord = "stop";
            }
            if (text.contains("stopp")) {
                stopWord = "stopp";
            }
            if (text.contains("Stop")) {
                stopWord = "Stop";
            }
            if (text.contains("Stopp")) {
                stopWord = "Stopp";
            }
            stop = true;
            String[] stripStop = text.split(stopWord);
            return stripStop[0];
        } else {
            stop = false;
            return text;
        }
    }

    public int charCount() {

        return chars;
    }

    public int rowCount() {

        return rows;
    }

    public String getLongestWord() {

        int length = 0;
        String[] wordArray = text.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            if (length < wordArray[i].chars().sum()) {
                length = wordArray[i].chars().sum();
                longestWord = wordArray[i];
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


}
