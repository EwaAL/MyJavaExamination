
package JavaExaminationMorseCode;

import java.util.Scanner;

public class LogicMorseCode {
    //Skriv ett program som gör om morsekod till engelska
    //och engelska till morsekod
    //❖ Skapa minst två felhanteringar i systemet som
    //hanterar två saker som användaren kan göra som går
    //utanför det vanliga användandet av systemet
    //Använd den internationella morsekoden (se slide 6)
    //för bokstäverna A till Z
    //❖ Korta och långa signaler ska representeras med
    //punkt (.) och bindestreck (-)
    //❖ F = ..-.
    //❖ Flera bokstäver skall gå att hantera men separation
    //av ord behöver inte hanteras
    //❖ …. . .--- = HEJ
    //❖ .... . .-.. .-.. --- .-- --- .-. .-.. -.. = HELLOWORLD
    //❖ HELLO WORLD = .... . .-.. .-.. --- .-- --- .-. .-.. -..
    private char[] splitTextToUse;
    private String textToUse;
    private ValidSigns myData = new ValidSigns();

    public boolean printOut(String text) {
        System.out.println(text);
        return true;
    }

    public String readText() {

        String text = "";

        Scanner myScan = new Scanner(System.in);
        System.out.println("Write something in English or in Morse Code");
        text = myScan.nextLine();

        return text;
    }


    public void splitText(String text) {
        splitTextToUse=text.toCharArray();
    }

    public int isEngOrMorse(String text){
        if (text.contains(".")||text.contains("-")){
            return 2;
        }else{
            return 1;
        }
    }
    public void morseToEng() {

    }

    public String engToMorse() {
    // omvandlar den inmatade texten till morsekod
        //loopa igenom arrayen med splitText och hämta morsetecknen
        //bygg ihop en sträng av varje morsetecken
        //separera tecknen med mellanslag
        String morseText="";
        ValidSigns myData = new ValidSigns();
        myData.Init();
        for(int i=0;i<splitTextToUse.length;i++){
            String morseSign = myData.getMorseCode(splitTextToUse[i]);
            morseText = morseText + morseSign;
        }
        return morseText;
    }

    public boolean validText() {
        int charCount = splitTextToUse.length;
        myData.Init();
        boolean isTrue = false;

        for (int i=0;i<charCount;i++) {
            char c = splitTextToUse[i];
            //gör om till versal om det är en bokstav
            if (Character.isLetter(c)){
                c=Character.toUpperCase(c);
            }
            isTrue = myData.isValid(c);
            if (!isTrue) {
                break;
            }
        }
        return isTrue;
    }
    public void setTextToUse(String text){
        textToUse=text;
    }
}

