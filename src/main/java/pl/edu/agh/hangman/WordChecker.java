package pl.edu.agh.hangman;

public class WordChecker {

    private final String wordToGuess;
    private String alreadyGuessed;


    public WordChecker(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        this.alreadyGuessed = "_".repeat(wordToGuess.length());
    }

    public boolean checkChar(char c) {
        StringBuilder result = new StringBuilder(this.alreadyGuessed);
        boolean charFound = false;
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if (this.wordToGuess.charAt(i) == c) {
                result.setCharAt(i, c);
                charFound = true;
            }
        }
        this.alreadyGuessed = result.toString();
        return charFound;
    }

    public String getAlreadyGuessed() {
        return alreadyGuessed;
    }
}
