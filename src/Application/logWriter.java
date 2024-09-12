package Application;

import java.io.IOException;
import java.io.PrintWriter;

public class logWriter {
    private PrintWriter writer;

    public logWriter() {
        try {
            writer = new PrintWriter("boogleLog.txt");
            writer.println("Start_Log");
            System.out.println("Opened File.");
        }
        catch (IOException e) {
            System.out.println("logWriter.java : Error encountered writing to boogleLog.txt");
        }
    }

    public void logGameEnd(Short guesses, boolean win) {
        writer.print("Game_end " + guesses);
        if (win) {
            writer.println("Win");
        }
        else {
            writer.println("Loss");
        }
    }

    public void logReset() {
        writer.println("Game Reset");
    }

    public void logGuess(Short guesses, String word) {
        writer.println("Guess " + word + " " + guesses);
    }

    public void closeLog() {
        writer.println("End_Log");
        writer.close();
    }
}
