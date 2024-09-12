package Application;

import java.util.ArrayList;

public class word {
    private ArrayList<Character> letters;
    private ArrayList<Short> evaluation;

    public word() {
        System.out.println("word.java : constructor called");
        letters = new ArrayList<Character> ();
        evaluation = new ArrayList<Short>();
        for (short index = 0; index < 5; index++) {
            evaluation.add(index, (short) -1);
        }
    }

    @Override
    public String toString() {
        String wordString = "<|";
        for (Character letter : letters) {
            wordString += letter;
        }
        wordString += "|>";

        String evaluationString = "<|";
        for (Short number : evaluation) {
            evaluationString += number;
        }
        evaluationString += "|>";

        return "Letters: " + wordString + "\nEvaluation: " + evaluationString;
    }

    public boolean addLetter(char letter) {
        if (letters.size() >= 5) {
            System.out.println("word.java : word already 5 letters long");
            return false;
        }
        letters.add(letter);
        System.out.println("word.java : added '" + letter + "' to word");
        return true;
    }

    public boolean deleteLetter() {
        if (letters.size() <= 0) {
            System.out.println("word.java : no letters in word");
            return false;
        }
        letters.remove(letters.size() - 1);
        System.out.println("word.java : last letter deleted");
        return true;
    }

    public boolean evaluateWord(String word) {
        /*
         * 0 : Not in Word (grey)
         * 1 : Letter in the wrong spot (yellow)
         * 2 : Right Letter, Right Place
         */
        if (letters.size() < 5) {
            return false;
        }

        System.out.println("word.java : evaluateWord called");

        for (short index = 0; index < 5; index++) {
            evaluation.set(index, (short) 0);  // By default, letter is not in word
            
            if (word.contains(letters.get(index).toString())) {  // Is Letter in word?
                evaluation.set(index, (short) 1);
            }

            if (word.charAt(index) == letters.get(index)) {  // Is the Letter in the right spot?
                evaluation.set(index, (short) 2);
            }
            System.out.println("word.java : " + letters.get(index) + " Evaluation: " + evaluation.get(index));
        }
        return true;
    }

    public ArrayList<Short> getEvaluation() {
        return evaluation;
    }

    public ArrayList<Character> getLetters() {
        return letters;
    }

    public String getWord() {
        String wordString = "";
        for (Character letter : letters) {
            wordString += letter;
        }
        return wordString;
    }
}
