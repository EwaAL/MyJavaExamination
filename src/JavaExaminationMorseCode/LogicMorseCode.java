
package JavaExaminationMorseCode;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class LogicMorseCode {

    //Skapa minst två felhanteringar i systemet som
    //hanterar två saker som användaren kan göra som går
    //utanför det vanliga användandet av systemet

    private String textIn;
    private String textOut;
    private char[] lettersIn;
    private String[] morseSignsIn;
    private ValidSigns myData = new ValidSigns();

    //***************************************************************
    public boolean handleInput(String text) {
        // - texten läses in och sparas i en klassvariabel.
        // - den inlästa texten omvandlas för att kunna skrivas ut
        // - om allt gått bra skickas true tillbaka.

        textIn = "";
        textOut = "";
        if (!text.isEmpty()) {
            saveTextIn(text);
        } else {
            saveTextIn(this.readText(4));
        }
        return getTextReadyToPrintOut();
    }

    //**************************************************************
    private String readText(int i) {
        // - läser in text från prompten och returnerar den

        String message = "";
        Scanner myScan = new Scanner(System.in);
        message = this.getMessage(i);
        System.out.println(message);
        return myScan.nextLine();
    }

    //**************************************************************
    private void saveTextIn(String text) {
        // - sparar input i en klassvariabel
        textIn = text;
    }

    //**************************************************************
    private boolean getTextReadyToPrintOut() {
        // - kollar om texten är morsekod eller engelska
        // - hanterar texten utifrån om det är morse eller engelska
        // - om allt gått bra returneras true

        boolean valid = false;
        int textType = this.engOrMorse(textIn);
        switch (textType) {
            case 1:
                //om det är morsetecken
                this.splitMorse();
                valid = this.convertMorse();
                break;
            case 2:
                //om det är bokstäver
                this.splitText();
                valid = this.convertEng();
                break;
            case 3:
                // om det är både morsetecken och bokstäver
                valid = false;
                break;
            case 4:
                // om det varken är morsetecken eller bokstäver
                valid = false;
                break;
            default:
                //TODO! vet inte vad som ska hända här
        }
        return valid;
    }

    //*****************************************************************
    private int engOrMorse(@NotNull String text) {
        // - kollar om texten innehåller morsetecken och/eller bokstäver
        // - returnerar 1 för morsetecken
        // - returnerar 2 för bokstäver
        // - returnerar 3 om det finns både morsetecken och bokstäver
        // - returnerar 4 om det varken finns morsetecken eller bokstäver

        boolean letters = false;
        boolean morse = false;

        if (text.contains(".") || text.contains("-")) {
            morse = true;
        }

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                letters = true;
                break;
            }
        }
        if (morse && !letters) {
            return 1;
        } else if (letters && !morse) {
            return 2;
        } else if (letters && morse) {
            return 3;
        } else {
            return 4;
        }
    }

    //****************************************************************
    private boolean convertEng() {
        // - laddar arrayer i dataklassen med giltiga tecken
        // - gör om tecknen till versaler, returnerar 1 om det inte gick
        // - bygger ihop en ny, konverterad, text
        // - om det går bra returneras true

        myData.Init();
        int count = lettersIn.length;
        boolean dataOK = false;

        try {
            for (int i = 0; i < count; i++) {
                char c = lettersIn[i]; // hämtar bokstav
                c = this.getUpperCase(c);//gör om bokstav till versal
                if (!(c == '1')) { // om inte 1 returneras byggs nya texten ihop
                    textOut = textOut + myData.getMorseCode(c) + " ";
                    dataOK = true;
                } else {
                    dataOK = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(getMessage(11));
        }
        textOut = this.getMessage(7) + textOut;
        return dataOK;
    }

    //****************************************************************
    private char getUpperCase(char c) {
        // - gör om en char till versal
        // - skickar tillbaka tecknet som versal
        // - om tecknet inte gick att omvandla skickas en etta tillbaka

        char newC = '1';
        if (Character.isLetter(c)) {
            newC = Character.toUpperCase(c);
        }
        return newC;
    }

    //****************************************************************
    private boolean convertMorse() {
        // - laddar arrayer i dataklassen med giltiga tecken
        // - bygger ihop en ny, konverterad, text
        // - om det går bra returneras true

        myData.Init();
        int count = morseSignsIn.length;
        boolean dataOK = false;

        try {
            for (int i = 0; i < count; i++) {
                String morse = morseSignsIn[i];
                textOut = textOut + myData.getChar(morse);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!textOut.isEmpty()) { // kollar att det finns en text
            textOut = getMessage(8) + textOut;
            dataOK = true;
        }
        return dataOK;
    }

    private void splitText() {
        if (textIn.contains(" ")) {
            String[] temp = textIn.split(" ");
            textIn = "";
            for (int i = 0; i < temp.length; i++) {
                textIn = textIn + temp[i];
            }
        }
        lettersIn = textIn.toCharArray();
    }

    private void splitMorse() {
        morseSignsIn = textIn.split(" ");
    }

    public boolean printOut(int i) {

        String message = this.getMessage(i);
        System.out.println(message);
        return true;
    }

    public boolean tryAgain(int i) {

        String answer = this.readText(i);
        boolean yesNo = false;

        if (answer.equalsIgnoreCase("Y")) {
            yesNo = true;
        } else if (answer.equalsIgnoreCase("N")) {
            yesNo = false;
            boolean test = this.printOut(10);

        } else {
            boolean test = this.printOut(9);
            answer = this.readText(i);
        }

        return yesNo;
    }

    private String getMessage(int i) {

        String message = "";
        switch (i) {
            case 1:
                message = "Hi there, welcome to the MorseCodeConverter!";
                break;
            case 2:
                message = "Please, remember, you can only use letters" +
                        " a-z or Morse code, okay, dear.";
                break;
            case 3:
                message = "Ready? Yay! Let's begin!";
                break;
            case 4:
                message = "Please just write something: ";
                break;
            case 5:
                message = "Say... Would you like to try again? Y/N";
                break;
            case 6:
                message = textOut;
                break;
            case 7:
                message = "Et voilá! The Morse code is: ";
                break;
            case 8:
                message = "No secret messages here, darling... You wrote: ";
                break;
            case 9:
                message = "Oooops! Please answer only with Y " +
                        "for yes or N for no, okay, dear.";
                break;
            case 10:
                message = "" +
                        "*** Thanks for stopping by, darling, " +
                        "have a niiiice day! ***";
                break;
            case 11:
                message = "An unexpected error occurred," +
                        " but don't worry, I'll fix it very soon, " +
                        "I'm sure!";
                break;
            case 12:
                message = "Testing Printing Function";
                break;
        }
        return message;
    }

    public void welcome() {
        for (int i = 1; i <= 3; i++) {
            boolean test = this.printOut(i);
        }
    }
}

