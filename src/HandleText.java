
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

        rows++;
        inputString = checkStopWord(inputString);
        if (!inputString.isEmpty()) {
            text = text + inputString;
        }
        return stop;
    }

    private String checkStopWord(String text) {

        String stopWord = "";

        if (text.equals("stop") || text.equals("stopp") || text.equals("Stop") || text.equals("Stopp")) {
            //om texten endast består av ordet "stop" i någon form sätts stoppords-markören till true,
            // raden tas bort från rad-räknaren och en tom string returneras
            stop = true;
            rows--;
            return "";

        } else if (text.contains("stop") || text.contains("stopp") || text.contains("Stop") || text.contains("Stopp")) {
            // Om texten innehåller ordet "stop" i någon form ska
            // stopp-ordet och ev efterkommande text tas bort från texten
            // Först sätts stoppords-markören till true,
            // sedan tar vi reda på vilket av stopp-orden som används i texten: stop, stopp, Stop, Stopp
            stop = true;
            if (text.contains("stop")) {
                stopWord = "stop";
            } else if (text.contains("stopp")) {
                stopWord = "stopp";
            } else if (text.contains("Stop")) {
                stopWord = "Stop";
            } else if (text.contains("Stopp")) {
                stopWord = "Stopp";
            } else {
                stopWord = "";
            }
            // Texten delas upp i en array
            // Vi tar reda på vilken position stopp-ordet har i arrayen
            // Sedan bygger vi ihop texten igen med allt som finns i arrayen före stopp-ordet
            // och separerar orden med blanksteg
            // Om stopp-ordet kommer först i arrayen ska den raden tas bort från rad-räknaren
            // Sist returneras texten
            String[] stripStop = text.split(" ");
            text="";
            for (int i = 0;i<stripStop.length;i++) {
                if (!stripStop[i].equals(stopWord)) {
                    text = text + " " + stripStop[i];
                }else{
                    if (i==0){
                        rows--;
                    }
                    break;
                }
            }
            return text.trim() ;
        } else {
            // Om det inte finns något stopp-ord i texten sätts stoppord-markören till false
            // och ursprungstexten returneras
            stop = false;
            return text.trim();
        }
    }

    public int charCount() {

        chars = text.length();
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

        if (!text.isEmpty()) {
            String[] wordArray = text.split(" ");
            words = wordArray.length;
            return words;
        }else{
            return 0;
        }
    }


}
