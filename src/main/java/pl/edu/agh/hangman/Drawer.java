package pl.edu.agh.hangman;

public class Drawer {

    public String createDrawing(String gallow, String word) {
        String result = "";
        String[] splitGallow = gallow.split("\n");

        for (int i = 0; i < splitGallow.length; i++) {
            result += splitGallow[i];
            if (i == 2) {
                result += " ".repeat(6) + word;
            }
            result += "\n";
        }
        return result;
    }
}
