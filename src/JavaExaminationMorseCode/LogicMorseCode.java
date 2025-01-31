
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
    private String[] textToUse;

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


    public void splitText() {

    }

    public void morseToEng() {

    }

    public void engToMorse() {

    }

}

