package pl.edu.agh.hangman;

import java.util.Scanner;

public class UserExperience {

    private final static int MAXOPTION = 4;

    private final static Scanner SC = new Scanner(System.in);

    public void printToUser(String string) {
        System.out.println(string);
    }

    public char getCharFromUser() {
        char guessChar;
        System.out.print("guess>>");
        guessChar = SC.nextLine().toUpperCase().charAt(0);
        return guessChar;
    }

    public int getWordLength() {
        int requestedLength = 0;
        System.out.println("What length of word do you need?");
        do {
            try {
                int testedInt = SC.nextInt();
                if (testedInt > 0) {
                    requestedLength = testedInt;
                } else
                    throw new IllegalArgumentException("Word lenght must be higher than 0! Provide another one");
                SC.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e);
            }
        } while (requestedLength == 0);
        return requestedLength;
    }

    public int getOption() {
        int optionChoosen = 0;
        System.out.println("Choose your option:");
        System.out.println("1 - random word from resources");
        System.out.println("2 - random word from resources, but with specified length");
        System.out.println("3 - enter your word");
        System.out.println("4 - word from WORDNIK");
        do {
            try {
                int testedInt = SC.nextInt();
                if (testedInt > 0 && testedInt <= MAXOPTION) {
                    optionChoosen = testedInt;
                } else
                    throw new IllegalArgumentException("Word lenght must be higher than 0! Provide another one");
                SC.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e);
            }

        } while (optionChoosen <= 0 || optionChoosen > MAXOPTION);

        return optionChoosen;
    }

    public String enterWord() {
        return SC.nextLine();
    }

}
