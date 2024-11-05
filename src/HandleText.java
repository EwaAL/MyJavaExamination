
public class HandleText {

    /*
     Denna klass:
     - Håller koll på om ett stopp-ord finns i en text
     - Håller koll på antal inlästa rader fram till ett stopp-ord
     - Räknar antal tecken i en text fram till ett stopp-ord
     - Räknar antalet ord i en text fram till ett stopp-ord
     - Letar upp det längsta ordet i en text. Om det finns flera ord
       som är lika långa väljs det första ordet ut
    */

    //**************************************************************************************
    private String text; //den inlästa texten
    private int rows; //antalet inlästa text-rader minus rad som börjar med stopp-ord
    private int chars; //antal tecken i en text fram till stoppord
    private int words;//antal ord i en text fram till stoppord
    private String longestWord;//längsta ordet/orden i en text
    private boolean stop;//vid true ska ingen mer rad läsas in

    //*************************************************************************************
    public HandleText() {
        //Grundvärden som sätts när konstruktorn initieras
        rows = 0;
        text = "";
        longestWord = "";
        chars = 0;
        words = 0;
        stop = false;
    }

    //*******************************************************************************************
    public boolean readLine(String inputString) {
        /*
         - Tar emot den inlästa textraden
         - Räknar upp radräknaren
         - Bygger ihop en ny String, utan stopp-ord
         - Om det första ordet som läses in är ett stopp-ord kommer den nybyggda Stringen vara tom
           (eftersom varken text efter stopp-ordet eller själva stopp-ordet ska användas)
         - Om den nybyggda Stringen inte är tom adderas nya Stringen till klassens text-attribut
         - Returnerar boolean som visar om mer text ska läsas in eller inte
        */

        rows++;
        inputString = buildNewString(inputString);
        if (!inputString.isEmpty()) text = text + inputString;
        return stop;
    }

    //**************************************************************************************
    private String buildNewString(String text) {
        /*
         - Tar emot texten som ska byggas om
         - Tar reda på om det finns ett stopp-ord. Tom variabel = inget stopp-ord
         - Vid tom variabel sätts stoppords-markören till false och ett blanksteg läggs till i textsträngen
         - Om det finns ett stopp-ord:
                - Stoppords-markören sätts till true
                - Texten delas upp i en array utifrån blanksteg
                - Textvariabeln töms så den kan återanvändas till nya texten utan stopp-ord
                - Textarrayen loopas fram till stopp-ordet
                - Ord som inte är ett stopp-ord sparas tillbaka i textvariabeln separerat med blanksteg
                - Om ordet är ett stopp-ord och det är första ordet i arrayen minskas radräknaren med 1 och inget ord sparas
                - Loopen avbryts
         - Den nya texten skickas tillbaka
        */

        String stopWord = getStopWord(text);
        if (stopWord.isEmpty()){
            stop = false;
            text = " " + text;
        }
        else {
            stop = true;
            String[] stripStop = text.split(" ");
            text = "";
            for (int i = 0; i < stripStop.length; i++) {
                if (!stripStop[i].equals(stopWord)) text = text + " " + stripStop[i];
                else {
                    if (i == 0) rows--;
                    break;
                }
            }
        }
        return text;
    }

    //*********************************************************************************************
    private String getStopWord(String text) {
        /*
         - Tar emot texten som ska kontrolleras för stopp-ord
         - Om det finns ett stopp-ord returneras detta
         - Om det inte finns något stopp-ord returneras tomt
        */

        if (text.contains("stopp")) {
            return "stopp";
        } else if (text.contains("stop")) {
            return "stop";
        } else if (text.contains("Stopp")) {
            return "Stopp";
        } else if (text.contains("Stop")) {
            return "Stop";
        } else {
            return "";
        }
    }

    //*************************************************************************************
    public int getAmountOfChars() {
        // - Tar reda på textens längd utan blanksteg i början och slutet, och returnerar antalet tecken

        chars = text.trim().length();
        return chars;
    }

    //*************************************************************************************
    public int getAmountOfRows() {
        // - Returnerar antalet inlästa rader

        return rows;
    }

    //**************************************************************************************
    public String getLongestWord() {
        /*
         - Skapar variabel för längden och sätter den till 0
         - Skapar en String-array av orden i texten
         - Loopar igenom arrayen och jämför ordens längd med variabeln för längd
         - Om ordet i arrayen är längre än summan i variabeln ändras variabelns summa till ordets längd
           och ordet sparas som det längsta ordet (skriver över tidigare ord)
         - Om ordet i arrayen är av samma längd som summan i variabeln läggs ordet till i variabeln
           med ett blanksteg mellan
         - Längsta ordet (eller sträng med längsta orden) returneras
        */

        int length = 0;
        String[] wordArray = text.split(" ");

        for (String s : wordArray)
            if (length < s.length()) {
                length = s.length();
                longestWord = s;
            }else if (length == s.length()) longestWord = longestWord + " " + s;
        return longestWord;
    }
    //******************************************************************************

    public int getAmountOfWords() {
        /*
         - Om det finns text delas den upp i en array
         - Längden på arrayen sparas i variabeln för antal ord
         - Om det inte finns någon text sätts variabeln för antal ord till 0
         - Antalet ord returneras
        */

        if (!text.isEmpty()) {
            text=text.trim();
            String[] wordArray = text.split(" ");
            words = wordArray.length;
        } else {
            words = 0;
        }
        return words;
    }
    //**************************************************************************************
    public boolean getStopStatus(){
        // - Returnerar boolean som visar om mer text ska läsas in eller inte
        return stop;
    }

    //**************************************************************************************
    public String getText(){
        // - Returnerar den inlästa texten
        return text;
    }
    //**************************************************************************************


}
