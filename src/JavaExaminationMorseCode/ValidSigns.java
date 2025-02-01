package JavaExaminationMorseCode;

import java.util.HashMap;

//*********************************************************************
// Klass som håller reda på giltiga tecken, dvs bokstäverna A-Z och
//  tecknen punkt och bindestreck till morsekoden
//*********************************************************************
public class ValidSigns {
    private HashMap<Character, String> letterAndMorse = new HashMap<>();
    private HashMap<String, Character> morseAndLetter = new HashMap<>();
    private char[] morseChars = new char[2];
    private char[] letterChars = new char[26];

    public void Init() {
        this.loadLetterAndMorse();
        this.loadMorseAndLetter();
        this.loadMorseChars();
        this.loadLetterChars();
    }
    private void loadLetterAndMorse() {
        // laddar alla bokstäver med tillhörande morsekod
        letterAndMorse.put('A', ".-");
        letterAndMorse.put('B', "-...");
        letterAndMorse.put('C', "-.-.");
        letterAndMorse.put('D', "-..");
        letterAndMorse.put('E', ".");
        letterAndMorse.put('F', "..-.");
        letterAndMorse.put('G', "--.");
        letterAndMorse.put('H', "....");
        letterAndMorse.put('I', "..");
        letterAndMorse.put('J', ".---");
        letterAndMorse.put('K', "-.-");
        letterAndMorse.put('L', ".-..");
        letterAndMorse.put('M', "--");
        letterAndMorse.put('N', "-.");
        letterAndMorse.put('O', "---");
        letterAndMorse.put('P', ".--.");
        letterAndMorse.put('Q', "--.-");
        letterAndMorse.put('R', ".-.");
        letterAndMorse.put('S', "...");
        letterAndMorse.put('T', "-");
        letterAndMorse.put('U', "..-");
        letterAndMorse.put('V', "...-");
        letterAndMorse.put('W', ".--");
        letterAndMorse.put('X', "-..-");
        letterAndMorse.put('Y', "-.--");
        letterAndMorse.put('Z', "--..");
    }

    private void loadMorseAndLetter() {
        // laddar alla morsekoder med tillhörande bokstäver
        morseAndLetter.put(".-", 'A');
        morseAndLetter.put("-...", 'B');
        morseAndLetter.put("-.-.", 'C');
        morseAndLetter.put("-..", 'D');
        morseAndLetter.put(".", 'E');
        morseAndLetter.put("..-.", 'F');
        morseAndLetter.put("--.", 'G');
        morseAndLetter.put("....", 'H');
        morseAndLetter.put("..", 'I');
        morseAndLetter.put(".---", 'J');
        morseAndLetter.put("-.-", 'K');
        morseAndLetter.put(".-..", 'L');
        morseAndLetter.put("--", 'M');
        morseAndLetter.put("-.", 'N');
        morseAndLetter.put("---", 'O');
        morseAndLetter.put(".--.", 'P');
        morseAndLetter.put("--.-", 'Q');
        morseAndLetter.put(".-.", 'R');
        morseAndLetter.put("...", 'S');
        morseAndLetter.put("-", 'T');
        morseAndLetter.put("..-", 'U');
        morseAndLetter.put("...-", 'V');
        morseAndLetter.put(".--", 'W');
        morseAndLetter.put("-..-", 'X');
        morseAndLetter.put("-.--", 'Y');
        morseAndLetter.put("--..", 'Z');
    }

    private void loadMorseChars() {
        // laddar morsetecknen
        morseChars[0] = '.';
        morseChars[1] = '-';

    }
    private void loadLetterChars(){
        letterChars[0]='A';
        letterChars[1]='B';
        letterChars[2]='C';
        letterChars[3]='D';
        letterChars[4]='E';
        letterChars[5]='F';
        letterChars[6]='G';
        letterChars[7]='H';
        letterChars[8]='I';
        letterChars[9]='J';
        letterChars[10]='K';
        letterChars[11]='L';
        letterChars[12]='M';
        letterChars[13]='N';
        letterChars[14]='O';
        letterChars[15]='P';
        letterChars[16]='Q';
        letterChars[17]='R';
        letterChars[18]='S';
        letterChars[19]='T';
        letterChars[20]='U';
        letterChars[21]='V';
        letterChars[22]='W';
        letterChars[23]='X';
        letterChars[24]='Y';
        letterChars[25]='Z';
    }

    public String getMorseCode(char sign) {
        System.out.println(letterAndMorse.get(sign));
        return "";
    }

    public char getChar(String morseCode) {
        return morseAndLetter.get(morseCode);
    }

    public boolean isValid(char c) {
        boolean validMorse = false;
        boolean validLetter = false;

        if (c == morseChars[0] || c == morseChars[1]) {
            validMorse = true;
        } else {
            for (char letterChar : letterChars) {
                if (letterChar == c) {
                    validLetter = true;
                    break;
                }
            }
        }
        boolean valid = false;
        if (validLetter || validMorse) {
            valid = true;
        }return valid;
    }
}








