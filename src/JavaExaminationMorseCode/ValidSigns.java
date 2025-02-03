package JavaExaminationMorseCode;

import java.util.HashMap;

//*********************************************************************

// Klass som håller reda på giltiga tecken, dvs bokstäverna A-Z och
//  tecknen punkt och bindestreck till morsekoden
//*********************************************************************
public class ValidSigns {
    private HashMap<Character, String> letterToMorse = new HashMap<>();
    private HashMap<String, Character> morseToLetter = new HashMap<>();
    private char[] letterChars = new char[26];

    public void Init() {
        this.loadLetterToMorse();
        this.loadMorseToLetter();
        this.loadLetterChars();
    }

    private void loadLetterToMorse() {
        // laddar alla bokstäver med tillhörande morsekod
        letterToMorse.put('A', ".-");
        letterToMorse.put('B', "-...");
        letterToMorse.put('C', "-.-.");
        letterToMorse.put('D', "-..");
        letterToMorse.put('E', ".");
        letterToMorse.put('F', "..-.");
        letterToMorse.put('G', "--.");
        letterToMorse.put('H', "....");
        letterToMorse.put('I', "..");
        letterToMorse.put('J', ".---");
        letterToMorse.put('K', "-.-");
        letterToMorse.put('L', ".-..");
        letterToMorse.put('M', "--");
        letterToMorse.put('N', "-.");
        letterToMorse.put('O', "---");
        letterToMorse.put('P', ".--.");
        letterToMorse.put('Q', "--.-");
        letterToMorse.put('R', ".-.");
        letterToMorse.put('S', "...");
        letterToMorse.put('T', "-");
        letterToMorse.put('U', "..-");
        letterToMorse.put('V', "...-");
        letterToMorse.put('W', ".--");
        letterToMorse.put('X', "-..-");
        letterToMorse.put('Y', "-.--");
        letterToMorse.put('Z', "--..");
    }

    private void loadMorseToLetter() {
        // laddar alla morsekoder med tillhörande bokstäver
        morseToLetter.put(".-", 'A');
        morseToLetter.put("-...", 'B');
        morseToLetter.put("-.-.", 'C');
        morseToLetter.put("-..", 'D');
        morseToLetter.put(".", 'E');
        morseToLetter.put("..-.", 'F');
        morseToLetter.put("--.", 'G');
        morseToLetter.put("....", 'H');
        morseToLetter.put("..", 'I');
        morseToLetter.put(".---", 'J');
        morseToLetter.put("-.-", 'K');
        morseToLetter.put(".-..", 'L');
        morseToLetter.put("--", 'M');
        morseToLetter.put("-.", 'N');
        morseToLetter.put("---", 'O');
        morseToLetter.put(".--.", 'P');
        morseToLetter.put("--.-", 'Q');
        morseToLetter.put(".-.", 'R');
        morseToLetter.put("...", 'S');
        morseToLetter.put("-", 'T');
        morseToLetter.put("..-", 'U');
        morseToLetter.put("...-", 'V');
        morseToLetter.put(".--", 'W');
        morseToLetter.put("-..-", 'X');
        morseToLetter.put("-.--", 'Y');
        morseToLetter.put("--..", 'Z');
    }

    private void loadLetterChars() {
        letterChars[0] = 'A';
        letterChars[1] = 'B';
        letterChars[2] = 'C';
        letterChars[3] = 'D';
        letterChars[4] = 'E';
        letterChars[5] = 'F';
        letterChars[6] = 'G';
        letterChars[7] = 'H';
        letterChars[8] = 'I';
        letterChars[9] = 'J';
        letterChars[10] = 'K';
        letterChars[11] = 'L';
        letterChars[12] = 'M';
        letterChars[13] = 'N';
        letterChars[14] = 'O';
        letterChars[15] = 'P';
        letterChars[16] = 'Q';
        letterChars[17] = 'R';
        letterChars[18] = 'S';
        letterChars[19] = 'T';
        letterChars[20] = 'U';
        letterChars[21] = 'V';
        letterChars[22] = 'W';
        letterChars[23] = 'X';
        letterChars[24] = 'Y';
        letterChars[25] = 'Z';
    }

    public String getMorseCode(char sign) {

        String morseSign = "";
        try {
            boolean valid = this.validLetter(sign);
            if (valid) {
                morseSign = letterToMorse.get(sign);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return morseSign;
    }

    public boolean validLetter(char c) {

        boolean valid = false;
        for (char letterChar : letterChars) {
            if (letterChar == c) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    public char getChar(String morseCode) {
        return morseToLetter.get(morseCode);
    }
}







