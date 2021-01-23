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
        String word = "";
        ui.printToUser("Welcome to the best HANGMAN game EVER!");

        switch (ui.getOption()) {

            case 1: {
                WordGenerator wordGenerator = new WordGenerator("slowa.txt");
                word = wordGenerator.getRandomWord();
                break;
            }
            case 2: {
                WordGenerator wordGenerator = new WordGenerator("slowa.txt");
                try {
                    word = wordGenerator.getRandomWord(ui.getWordLength());
                } catch (Exception e) {
                    System.err.println(e);
                }
                break;
            }
            case 3: {
                WordGenerator wordGenerator = new WordGenerator(ui.enterWord());
                break;
            }
            case 4: {//TODO
                break;
            }

        }

        WordChecker wordChecker = new WordChecker(word);

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
        } while ((faults < HANGMANPICS.length - 1) && (!wonGame));

        if (wonGame)
            ui.printToUser(HAPPYFACE);
        else {
            ui.printToUser(drawer.createDrawing(HANGMANPICS[faults], wordChecker.getAlreadyGuessed()));
            ui.printToUser(SADFACE);
            ui.printToUser("The word was: " + word);
        }

    }
}
