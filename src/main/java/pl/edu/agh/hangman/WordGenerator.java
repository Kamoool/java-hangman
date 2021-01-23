package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {


    private String fileAddress;
    private File wordsFile;
    private ArrayList<String> wordsList;

    public WordGenerator(String fileAddress) {
        this.fileAddress = fileAddress;
        wordsList = new ArrayList<String>();
        wordsFile = new File("src\\main\\resources\\" + fileAddress);


        if (wordsFile.length() < 1){
            System.out.println("File contains " + wordsFile.length() + " symbols.");
            System.out.println("File is not correct, loading default File. To change input file use changeInputFile method. -> changeInputFile(\"FileName.txt\")");
            wordsFile = new File("src\\main\\resources\\slowa.txt");
        }

            listGeneratorFromFile();

    }


    public void changeInputFile(String fileAddress){
        this.fileAddress = fileAddress;

            wordsFile = new File("src\\main\\resources\\" + fileAddress);
            System.out.println("File contains " + wordsFile.length() + " symbols.");

            if (wordsFile.length() < 1) {
                System.out.println("File is not correct, insert correct file into resources catalog and use fixFile Class (fixFile(\"FileName.txt\"))");
            } else {
                listGeneratorFromFile();
            }
    }



    private void listGeneratorFromFile(){
        wordsList = new ArrayList<String>();
        Scanner s = null;
        try {
            s = new Scanner(wordsFile);
        } catch (FileNotFoundException e) {
            System.out.println("File is not correct, insert correct file into resources catalog and use changeInputFile Method. -> changeInputFile(\"FileName.txt\")");
            e.printStackTrace();
        }

        while(s.hasNextLine()){
            wordsList.add(s.nextLine());
        }

        System.out.println("Words added succesfully, there are " + wordsList.size() + " words in the List.");
    }

    public String getRandomWord(){
        Random rand = new Random();
        return wordsList.get(rand.nextInt(wordsList.size())).toUpperCase();
    }

}
