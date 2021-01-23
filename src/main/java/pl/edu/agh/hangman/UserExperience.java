package pl.edu.agh.hangman;

import java.util.Scanner;

public class UserExperience {

    private final static Scanner sc = new Scanner(System.in);

    public void printToUser(String string) {
        System.out.println(string);
    }

    public char getCharFromUser() {
        char guessChar;
        System.out.print("guess>>");
        guessChar = sc.nextLine().toUpperCase().charAt(0);
        return guessChar;
    }

}
