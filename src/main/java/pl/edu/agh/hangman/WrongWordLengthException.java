package pl.edu.agh.hangman;

class WrongWordLengthException extends Exception {

    public WrongWordLengthException(String message) {
        super(message);
    }

}