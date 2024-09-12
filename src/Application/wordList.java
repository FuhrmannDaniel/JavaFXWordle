package Application;

import java.io.*;
import java.util.*;

public class wordList {
    private HashSet<String> wordSet;
    private String boogleWord;
    private Random random;

    public wordList() {
        wordSet = new HashSet<String>();
        random = new Random();
        boolean debug = false;
        Scanner inFile = null;

        try {
            inFile = new Scanner(new FileReader("./src/boogleWordList.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(0);
        }

        while (inFile.hasNextLine()) {
            if (debug) {
                String newWord = inFile.nextLine();
                System.out.println("Adding '" + newWord + "' to wordArrayList");
                wordSet.add(newWord);
            }
            else {
                wordSet.add(inFile.nextLine());
            }
        }

        if (debug) {
            int randomIndex = random.nextInt(wordSet.size());
            System.out.println("Random Index: " + randomIndex);
            Object[] wordsArray = wordSet.toArray();
            boogleWord = (String) wordsArray[randomIndex];
            System.out.println(boogleWord);
        }
        else {
            Object[] wordsArray = wordSet.toArray();
            boogleWord = (String) wordsArray[random.nextInt(wordSet.size())];
            System.out.println(boogleWord);
        }
        inFile.close();
    }

    public String getBoogleWord() {
        return boogleWord;
    }

    public boolean isValidWord(String word) {
        return wordSet.contains(word);
    }
}
