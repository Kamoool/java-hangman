package pl.edu.agh.hangman;

public class Hangman {


    public static final String HAPPYFACE = "YOU ROCK! CONGRATS! (⌐ ͡■ ͜ʖ ͡■)";
    public static final String SADFACE = "You LOSE! ¯\\_(ツ)_/¯";


    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {

        //Initialize
        Drawer drawer = new Drawer();
        UserExperience ui = new UserExperience();
        WordGenerator wordGenerator = new WordGenerator("slowa.txt");

        String word = wordGenerator.getRandomWord();

        WordChecker wordChecker = new WordChecker(word);

        ui.printToUser("Welcome to the best HANGMAN game EVER!");

        boolean wonGame = false;
        int faults = 0;
        char guessChar;
        do {
            ui.printToUser(drawer.createDrawing(HANGMANPICS[faults], wordChecker.getAlreadyGuessed()));
            guessChar = ui.getCharFromUser();
            if (!(wordChecker.checkChar(guessChar)))
                faults++;
            if (wordChecker.getAlreadyGuessed().equals(word)) {
                wonGame = true;
            }

        } while ((faults < HANGMANPICS.length) && (!wonGame));

        if (wonGame)
            ui.printToUser(HAPPYFACE);
        else
            ui.printToUser(SADFACE);
    }
}
