package Application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;

public class Controller {
    private short guess = 0;  // boogle board line number
    private short letterIndex = 0;  // boogle board letter index
    private int gamesPlayed = 0;  // Total number of games played
    private int[] guessDistribution = new int[6];

    private wordList gameWordList = new wordList();
    public static logWriter log = new logWriter();
    
    // words
    private word word0 = new word();
    private word word1 = new word();
    private word word2 = new word();
    private word word3 = new word();
    private word word4 = new word();
    private word word5 = new word();

    // Boogle Board
        // Line 0
        @FXML private Label line00;
        @FXML private Label line01;
        @FXML private Label line02;
        @FXML private Label line03;
        @FXML private Label line04;

        // Line 1
        @FXML private Label line10;
        @FXML private Label line11;
        @FXML private Label line12;
        @FXML private Label line13;
        @FXML private Label line14;

        // Line 2
        @FXML private Label line20;
        @FXML private Label line21;
        @FXML private Label line22;
        @FXML private Label line23;
        @FXML private Label line24;

        // Line 3
        @FXML private Label line30;
        @FXML private Label line31;
        @FXML private Label line32;
        @FXML private Label line33;
        @FXML private Label line34;

        // Line 4
        @FXML private Label line40;
        @FXML private Label line41;
        @FXML private Label line42;
        @FXML private Label line43;
        @FXML private Label line44;

        // Line 5
        @FXML private Label line50;
        @FXML private Label line51;
        @FXML private Label line52;
        @FXML private Label line53;
        @FXML private Label line54;
    
    // Keyboard Keys
        // Letters
        @FXML private Button aKey;
        @FXML private Button bKey;
        @FXML private Button cKey;
        @FXML private Button dKey;
        @FXML private Button eKey;
        @FXML private Button fKey;
        @FXML private Button gKey;
        @FXML private Button hKey;
        @FXML private Button iKey;
        @FXML private Button jKey;
        @FXML private Button kKey;
        @FXML private Button lKey;
        @FXML private Button mKey;
        @FXML private Button nKey;
        @FXML private Button oKey;
        @FXML private Button pKey;
        @FXML private Button qKey;
        @FXML private Button rKey;
        @FXML private Button sKey;
        @FXML private Button tKey;
        @FXML private Button uKey;
        @FXML private Button vKey;
        @FXML private Button wKey;
        @FXML private Button xKey;
        @FXML private Button yKey;
        @FXML private Button zKey;
    
    // Miscellaneous Buttons
    @FXML private Button statsButton;
    @FXML private Button resetButton;

    private void disableKeyboard() {
        aKey.setDisable(true);
        bKey.setDisable(true);
        cKey.setDisable(true);
        dKey.setDisable(true);
        eKey.setDisable(true);
        fKey.setDisable(true);
        gKey.setDisable(true);
        hKey.setDisable(true);
        iKey.setDisable(true);
        jKey.setDisable(true);
        kKey.setDisable(true);
        lKey.setDisable(true);
        mKey.setDisable(true);
        nKey.setDisable(true);
        oKey.setDisable(true);
        pKey.setDisable(true);
        qKey.setDisable(true);
        rKey.setDisable(true);
        sKey.setDisable(true);
        tKey.setDisable(true);
        uKey.setDisable(true);
        vKey.setDisable(true);
        wKey.setDisable(true);
        xKey.setDisable(true);
        yKey.setDisable(true);
        zKey.setDisable(true);
    }

    public void showStats(ActionEvent e) {
        double winRate = 100 * gamesPlayed / (guessDistribution[0] + guessDistribution[1] + guessDistribution[2] + guessDistribution[3] + guessDistribution[4] + guessDistribution[5]);
        String message = "Games Played: " + gamesPlayed + "\nGuess Distribution\n";
        message += "Win Rate: " + winRate + "%\n\nGuess Distribution\n";

        message += "1 Guess:   " + guessDistribution[0] + "\n";
        message += "2 Guesses: " + guessDistribution[1] + "\n";
        message += "3 Guesses: " + guessDistribution[2] + "\n";
        message += "4 Guesses: " + guessDistribution[3] + "\n";
        message += "5 Guesses: " + guessDistribution[4] + "\n";
        message += "6 Guesses: " + guessDistribution[5];

        JOptionPane.showMessageDialog(null, message, "Game Statistics", JOptionPane.NO_OPTION);
    }

    private boolean gameOver(String word) {
        if (word.equals(gameWordList.getBoogleWord())) {
            disableKeyboard();
            log.logGameEnd(guess, true);
            guessDistribution[(guess-1)]++;
            gamesPlayed++;
            JOptionPane.showMessageDialog(null, "You won the game with " + guess + " guesses!\nClick Reset to play another round", "You Win!", JOptionPane.INFORMATION_MESSAGE);
            showStats(null);
            return true;
        }
        else {
            return false;
        }
    }

    public void closeGame(EventType<WindowEvent> WINDOW_CLOSE_REQUEST) {
        System.out.println("Closing window");
        log.closeLog();
    }

    private void updateKeyboard(Short evaluation, Character letter) {
        switch (letter) {
            case 'a':
                switch (evaluation) {
                    case 0:
                        aKey.setStyle("-fx-background-color: #7e7e7e;");
                        aKey.setDisable(true);
                        break;
                    case 1:
                        aKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        aKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'b':
                switch (evaluation) {
                    case 0:
                        bKey.setStyle("-fx-background-color: #7e7e7e;");
                        bKey.setDisable(true);
                        break;
                    case 1:
                        bKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        bKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'c':
                switch (evaluation) {
                    case 0:
                        cKey.setStyle("-fx-background-color: #7e7e7e;");
                        cKey.setDisable(true);
                        break;
                    case 1:
                        cKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        cKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'd':
                switch (evaluation) {
                    case 0:
                        dKey.setStyle("-fx-background-color: #7e7e7e;");
                        dKey.setDisable(true);
                        break;
                    case 1:
                        dKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        dKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'e':
                switch (evaluation) {
                    case 0:
                        eKey.setStyle("-fx-background-color: #7e7e7e;");
                        eKey.setDisable(true);
                        break;
                    case 1:
                        eKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        eKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'f':
                switch (evaluation) {
                    case 0:
                        fKey.setStyle("-fx-background-color: #7e7e7e;");
                        fKey.setDisable(true);
                        break;
                    case 1:
                        fKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        fKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'g':
                switch (evaluation) {
                    case 0:
                        gKey.setStyle("-fx-background-color: #7e7e7e;");
                        gKey.setDisable(true);
                        break;
                    case 1:
                        gKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        gKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'h':
                switch (evaluation) {
                    case 0:
                        hKey.setStyle("-fx-background-color: #7e7e7e;");
                        hKey.setDisable(true);
                        break;
                    case 1:
                        hKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        hKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'i':
                switch (evaluation) {
                    case 0:
                        iKey.setStyle("-fx-background-color: #7e7e7e;");
                        iKey.setDisable(true);
                        break;
                    case 1:
                        iKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        iKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'j':
                switch (evaluation) {
                    case 0:
                        jKey.setStyle("-fx-background-color: #7e7e7e;");
                        jKey.setDisable(true);
                        break;
                    case 1:
                        jKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        jKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'k':
                switch (evaluation) {
                    case 0:
                        kKey.setStyle("-fx-background-color: #7e7e7e;");
                        kKey.setDisable(true);
                        break;
                    case 1:
                        kKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        kKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'l':
                switch (evaluation) {
                    case 0:
                        lKey.setStyle("-fx-background-color: #7e7e7e;");
                        lKey.setDisable(true);
                        break;
                    case 1:
                        lKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        lKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'm':
                switch (evaluation) {
                    case 0:
                        mKey.setStyle("-fx-background-color: #7e7e7e;");
                        mKey.setDisable(true);
                        break;
                    case 1:
                        mKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        mKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'n':
                switch (evaluation) {
                    case 0:
                        nKey.setStyle("-fx-background-color: #7e7e7e;");
                        nKey.setDisable(true);
                        break;
                    case 1:
                        nKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        nKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'o':
                switch (evaluation) {
                    case 0:
                        oKey.setStyle("-fx-background-color: #7e7e7e;");
                        oKey.setDisable(true);
                        break;
                    case 1:
                        oKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        oKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'p':
                switch (evaluation) {
                    case 0:
                        pKey.setStyle("-fx-background-color: #7e7e7e;");
                        pKey.setDisable(true);
                        break;
                    case 1:
                        pKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        pKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'q':
                switch (evaluation) {
                    case 0:
                        qKey.setStyle("-fx-background-color: #7e7e7e;");
                        qKey.setDisable(true);
                        break;
                    case 1:
                        qKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        qKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'r':
                switch (evaluation) {
                    case 0:
                        rKey.setStyle("-fx-background-color: #7e7e7e;");
                        rKey.setDisable(true);
                        break;
                    case 1:
                        rKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        rKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 's':
                switch (evaluation) {
                    case 0:
                        sKey.setStyle("-fx-background-color: #7e7e7e;");
                        sKey.setDisable(true);
                        break;
                    case 1:
                        sKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        sKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 't':
                switch (evaluation) {
                    case 0:
                        tKey.setStyle("-fx-background-color: #7e7e7e;");
                        tKey.setDisable(true);
                        break;
                    case 1:
                        tKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        tKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'u':
                switch (evaluation) {
                    case 0:
                        uKey.setStyle("-fx-background-color: #7e7e7e;");
                        uKey.setDisable(true);
                        break;
                    case 1:
                        uKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        uKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'v':
                switch (evaluation) {
                    case 0:
                        vKey.setStyle("-fx-background-color: #7e7e7e;");
                        vKey.setDisable(true);
                        break;
                    case 1:
                        vKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        vKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'w':
                switch (evaluation) {
                    case 0:
                        wKey.setStyle("-fx-background-color: #7e7e7e;");
                        wKey.setDisable(true);
                        break;
                    case 1:
                        wKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        wKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'x':
                switch (evaluation) {
                    case 0:
                        xKey.setStyle("-fx-background-color: #7e7e7e;");
                        xKey.setDisable(true);
                        break;
                    case 1:
                        xKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        xKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'y':
                switch (evaluation) {
                    case 0:
                        yKey.setStyle("-fx-background-color: #7e7e7e;");
                        yKey.setDisable(true);
                        break;
                    case 1:
                        yKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        yKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
            case 'z':
                switch (evaluation) {
                    case 0:
                        zKey.setStyle("-fx-background-color: #7e7e7e;");
                        zKey.setDisable(true);
                        break;
                    case 1:
                        zKey.setStyle("-fx-background-color: #ffff54;");
                        break;
                    case 2:
                        zKey.setStyle("-fx-background-color: #76ff54;");
                        break;
                
                    default:
                        System.out.println("Controller.java : Error Encountered Updating Keyboard");
                        break;
                }
                break;
        
            default:
                System.out.println("Controller.java : Error Encountered Updating Keyboard");
                break;
        }
    }

    private void updateBoard(Short evaluation, Short index) {
        switch (guess) {
            case 0:
                switch (index) {
                    case 0:
                    switch (evaluation) {
                        case 0:
                            line00.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line00.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line00.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 1:
                    switch (evaluation) {
                        case 0:
                            line01.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line01.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line01.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 2:
                    switch (evaluation) {
                        case 0:
                            line02.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line02.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line02.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 3:
                    switch (evaluation) {
                        case 0:
                            line03.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line03.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line03.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 4:
                    switch (evaluation) {
                        case 0:
                            line04.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line04.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line04.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                
                    default:
                        break;
                }
                break;
            case 1:
                switch (index) {
                    case 0:
                    switch (evaluation) {
                        case 0:
                            line10.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line10.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line10.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 1:
                    switch (evaluation) {
                        case 0:
                            line11.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line11.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line11.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 2:
                    switch (evaluation) {
                        case 0:
                            line12.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line12.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line12.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 3:
                    switch (evaluation) {
                        case 0:
                            line13.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line13.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line13.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 4:
                    switch (evaluation) {
                        case 0:
                            line14.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line14.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line14.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                
                    default:
                        break;
                }
                break;
            case 2:
                switch (index) {
                    case 0:
                    switch (evaluation) {
                        case 0:
                            line20.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line20.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line20.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 1:
                    switch (evaluation) {
                        case 0:
                            line21.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line21.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line21.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 2:
                    switch (evaluation) {
                        case 0:
                            line22.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line22.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line22.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 3:
                    switch (evaluation) {
                        case 0:
                            line23.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line23.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line23.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 4:
                    switch (evaluation) {
                        case 0:
                            line24.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line24.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line24.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                
                    default:
                        break;
                }
                break;
            case 3:
                switch (index) {
                    case 0:
                    switch (evaluation) {
                        case 0:
                            line30.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line30.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line30.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 1:
                    switch (evaluation) {
                        case 0:
                            line31.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line31.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line31.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 2:
                    switch (evaluation) {
                        case 0:
                            line32.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line32.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line32.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 3:
                    switch (evaluation) {
                        case 0:
                            line33.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line33.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line33.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 4:
                    switch (evaluation) {
                        case 0:
                            line34.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line34.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line34.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                
                    default:
                        break;
                }
                break;
            case 4:
                switch (index) {
                    case 0:
                    switch (evaluation) {
                        case 0:
                            line40.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line40.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line40.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 1:
                    switch (evaluation) {
                        case 0:
                            line41.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line41.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line41.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 2:
                    switch (evaluation) {
                        case 0:
                            line42.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line42.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line42.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 3:
                    switch (evaluation) {
                        case 0:
                            line43.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line43.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line43.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 4:
                    switch (evaluation) {
                        case 0:
                            line44.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line44.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line44.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                
                    default:
                        break;
                }
                break;
            case 5:
                switch (index) {
                    case 0:
                    switch (evaluation) {
                        case 0:
                            line50.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line50.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line50.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 1:
                    switch (evaluation) {
                        case 0:
                            line51.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line51.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line51.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 2:
                    switch (evaluation) {
                        case 0:
                            line52.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line52.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line52.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 3:
                    switch (evaluation) {
                        case 0:
                            line53.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line53.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line53.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                    case 4:
                    switch (evaluation) {
                        case 0:
                            line54.setStyle("-fx-background-color: #7e7e7e;");
                            break;
                        case 1:
                            line54.setStyle("-fx-background-color: #ffff54;");
                            break;
                        case 2:
                            line54.setStyle("-fx-background-color: #76ff54;");
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered Updating Game Board");
                            break;
                    }
                        break;
                
                    default:
                        break;
                }
                break;
        
            default:
                break;
        }
    }

    private void removeLetter() {
        switch (guess) {
            case 0:
                switch (letterIndex) {
                    case 0:
                        line00.setText("");
                        break;
                    case 1:
                        line01.setText("");
                        break;
                    case 2:
                        line02.setText("");
                        break;
                    case 3:
                        line03.setText("");
                        break;
                    case 4:
                        line04.setText("");
                        break;
                
                    default:
                        break;
                }
                break;
            case 1:
                switch (letterIndex) {
                    case 0:
                        line10.setText("");
                        break;
                    case 1:
                        line11.setText("");
                        break;
                    case 2:
                        line12.setText("");
                        break;
                    case 3:
                        line13.setText("");
                        break;
                    case 4:
                        line14.setText("");
                        break;
                
                    default:
                        break;
                }
                break;
            case 2:
                switch (letterIndex) {
                    case 0:
                        line20.setText("");
                        break;
                    case 1:
                        line21.setText("");
                        break;
                    case 2:
                        line22.setText("");
                        break;
                    case 3:
                        line23.setText("");
                        break;
                    case 4:
                        line24.setText("");
                        break;
                
                    default:
                        break;
                }
                break;
            case 3:
                switch (letterIndex) {
                    case 0:
                        line30.setText("");
                        break;
                    case 1:
                        line31.setText("");
                        break;
                    case 2:
                        line32.setText("");
                        break;
                    case 3:
                        line33.setText("");
                        break;
                    case 4:
                        line34.setText("");
                        break;
                
                    default:
                        break;
                }
                break;
            case 4:
                switch (letterIndex) {
                    case 0:
                        line40.setText("");
                        break;
                    case 1:
                        line41.setText("");
                        break;
                    case 2:
                        line42.setText("");
                        break;
                    case 3:
                        line43.setText("");
                        break;
                    case 4:
                        line44.setText("");
                        break;
                
                    default:
                        break;
                }
                break;
            case 5:
                switch (letterIndex) {
                    case 0:
                        line50.setText("");
                        break;
                    case 1:
                        line51.setText("");
                        break;
                    case 2:
                        line52.setText("");
                        break;
                    case 3:
                        line53.setText("");
                        break;
                    case 4:
                        line54.setText("");
                        break;
                
                    default:
                        break;
                }
                break;
        
            default:
                break;
        }
    }

    public void deleteKey(ActionEvent e) {
        boolean result;
        switch (guess) {
            case 0:
                result = word0.deleteLetter();
                if (!result) {
                    System.out.println("Controller.java : Error Encountered Deleting Letter");
                }
                else {
                    letterIndex--;
                    removeLetter();
                }
                break;
            case 1:
                result = word1.deleteLetter();
                if (!result) {
                    System.out.println("Controller.java : Error Encountered Deleting Letter");
                }
                else {
                    letterIndex--;
                    removeLetter();
                }
                break;
            case 2:
                result = word2.deleteLetter();
                if (!result) {
                    System.out.println("Controller.java : Error Encountered Deleting Letter");
                }
                else {
                    letterIndex--;
                    removeLetter();
                }
                break;
            case 3:
                result = word3.deleteLetter();
                if (!result) {
                    System.out.println("Controller.java : Error Encountered Deleting Letter");
                }
                else {
                    letterIndex--;
                    removeLetter();
                }
                break;
            case 4:
                result = word4.deleteLetter();
                if (!result) {
                    System.out.println("Controller.java : Error Encountered Deleting Letter");
                }
                else {
                    letterIndex--;
                    removeLetter();
                }
                break;
            case 5:
                result = word5.deleteLetter();
                if (!result) {
                    System.out.println("Controller.java : Error Encountered Deleting Letter");
                }
                else {
                    letterIndex--;
                    removeLetter();
                }
                break;
        
            default:
                break;
        }
    } 

    public void enterKey(ActionEvent e) {
        boolean result;
        boolean validWord;
        switch (guess) {
            case 0:
                result = word0.evaluateWord(gameWordList.getBoogleWord());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "You must enter all 5 letters before you can check the word.", "Incomplete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    validWord = gameWordList.isValidWord(word0.getWord());
                    if (!validWord) {
                        JOptionPane.showMessageDialog(null, "The submitted word is not in our word list.", "Unknown Word", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        ArrayList<Short> evaluation = word0.getEvaluation();
                        ArrayList<Character> letters = word0.getLetters();
                        for (int index = 0; index < 5; index++) {
                            Short eval = evaluation.get(index);

                            updateKeyboard(eval, letters.get(index));
                            updateBoard(eval, (short) index);
                        }
                        guess++;
                        log.logGuess(guess, word0.getWord());
                        letterIndex = 0;
                        gameOver(word0.getWord());
                    }
                }
                break;
            case 1:
                result = word1.evaluateWord(gameWordList.getBoogleWord());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "You must enter all 5 letters before you can check the word.", "Incomplete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    validWord = gameWordList.isValidWord(word1.getWord());
                    if (!validWord) {
                        JOptionPane.showMessageDialog(null, "The submitted word is not in our word list.", "Unknown Word", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        ArrayList<Short> evaluation = word1.getEvaluation();
                        ArrayList<Character> letters = word1.getLetters();
                        for (int index = 0; index < 5; index++) {
                            Short eval = evaluation.get(index);

                            updateKeyboard(eval, letters.get(index));
                            updateBoard(eval, (short) index);
                        }
                        guess++;
                        log.logGuess(guess, word1.getWord());
                        letterIndex = 0;
                        gameOver(word1.getWord());
                    }
                }
                break;
            case 2:
                result = word2.evaluateWord(gameWordList.getBoogleWord());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "You must enter all 5 letters before you can check the word.", "Incomplete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    validWord = gameWordList.isValidWord(word2.getWord());
                    if (!validWord) {
                        JOptionPane.showMessageDialog(null, "The submitted word is not in our word list.", "Unknown Word", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        ArrayList<Short> evaluation = word2.getEvaluation();
                        ArrayList<Character> letters = word2.getLetters();
                        for (int index = 0; index < 5; index++) {
                            Short eval = evaluation.get(index);

                            updateKeyboard(eval, letters.get(index));
                            updateBoard(eval, (short) index);
                        }
                        guess++;
                        log.logGuess(guess, word2.getWord());
                        letterIndex = 0;
                        gameOver(word2.getWord());
                    }
                }
                break;
            case 3:
                result = word3.evaluateWord(gameWordList.getBoogleWord());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "You must enter all 5 letters before you can check the word.", "Incomplete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    validWord = gameWordList.isValidWord(word3.getWord());
                    if (!validWord) {
                        JOptionPane.showMessageDialog(null, "The submitted word is not in our word list.", "Unknown Word", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        ArrayList<Short> evaluation = word3.getEvaluation();
                        ArrayList<Character> letters = word3.getLetters();
                        for (int index = 0; index < 5; index++) {
                            Short eval = evaluation.get(index);

                            updateKeyboard(eval, letters.get(index));
                            updateBoard(eval, (short) index);
                        }
                        guess++;
                        log.logGuess(guess, word3.getWord());
                        letterIndex = 0;
                        gameOver(word3.getWord());
                    }
                }
                break;
            case 4:
                result = word4.evaluateWord(gameWordList.getBoogleWord());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "You must enter all 5 letters before you can check the word.", "Incomplete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    validWord = gameWordList.isValidWord(word4.getWord());
                    if (!validWord) {
                        JOptionPane.showMessageDialog(null, "The submitted word is not in our word list.", "Unknown Word", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        ArrayList<Short> evaluation = word4.getEvaluation();
                        ArrayList<Character> letters = word4.getLetters();
                        for (int index = 0; index < 5; index++) {
                            Short eval = evaluation.get(index);

                            updateKeyboard(eval, letters.get(index));
                            updateBoard(eval, (short) index);
                        }
                        guess++;
                        log.logGuess(guess, word4.getWord());
                        letterIndex = 0;
                        gameOver(word4.getWord());
                    }
                }
                break;
            case 5:
                result = word5.evaluateWord(gameWordList.getBoogleWord());
                if (!result) {
                    JOptionPane.showMessageDialog(null, "You must enter all 5 letters before you can check the word.", "Incomplete Word", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    validWord = gameWordList.isValidWord(word5.getWord());
                    if (!validWord) {
                        JOptionPane.showMessageDialog(null, "The submitted word is not in our word list.", "Unknown Word", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        ArrayList<Short> evaluation = word5.getEvaluation();
                        ArrayList<Character> letters = word5.getLetters();
                        for (int index = 0; index < 5; index++) {
                            Short eval = evaluation.get(index);

                            updateKeyboard(eval, letters.get(index));
                            updateBoard(eval, (short) index);
                        }
                        guess++;
                        log.logGuess(guess, word5.getWord());
                        letterIndex = 0;
                        if (!gameOver(word5.getWord())) {
                            disableKeyboard();
                            log.logGameEnd(guess, false);
                            gamesPlayed++;
                            JOptionPane.showMessageDialog(null, "You did not guess in time :(\nThe word was: " + gameWordList.getBoogleWord(), "You Lost", JOptionPane.INFORMATION_MESSAGE);
                            showStats(null);
                        }
                    }
                }
                break;
        
            default:
                System.out.println("Controller.java : Error Encountered Processing Turn");
                break;
        }
    }

    public void keyboardLetterPressed(ActionEvent e) {
        Button button = (Button) e.getSource();
        String letter = button.getText().toLowerCase();
        boolean result;
        
        switch (guess) {
            case 0:
                result = word0.addLetter(letter.charAt(0));
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Each word can only have 5 letters.", "5 Letter Words Only", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    switch (letterIndex) {
                        case 0:
                            line00.setText(letter.toUpperCase());
                            break;
                        case 1:
                            line01.setText(letter.toUpperCase());
                            break;
                        case 2:
                            line02.setText(letter.toUpperCase());
                            break;
                        case 3:
                            line03.setText(letter.toUpperCase());
                            break;
                        case 4:
                            line04.setText(letter.toUpperCase());
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered in determining letter index to update");
                            break;
                    }
                    letterIndex++;
                }
                break;
            case 1:
                result = word1.addLetter(letter.charAt(0));
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Each word can only have 5 letters.", "5 Letter Words Only", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    switch (letterIndex) {
                        case 0:
                            line10.setText(letter.toUpperCase());
                            break;
                        case 1:
                            line11.setText(letter.toUpperCase());
                            break;
                        case 2:
                            line12.setText(letter.toUpperCase());
                            break;
                        case 3:
                            line13.setText(letter.toUpperCase());
                            break;
                        case 4:
                            line14.setText(letter.toUpperCase());
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered in determining letter index to update");
                            break;
                    }
                    letterIndex++;
                }
                break;
            case 2:
                result = word2.addLetter(letter.charAt(0));
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Each word can only have 5 letters.", "5 Letter Words Only", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    switch (letterIndex) {
                        case 0:
                            line20.setText(letter.toUpperCase());
                            break;
                        case 1:
                            line21.setText(letter.toUpperCase());
                            break;
                        case 2:
                            line22.setText(letter.toUpperCase());
                            break;
                        case 3:
                            line23.setText(letter.toUpperCase());
                            break;
                        case 4:
                            line24.setText(letter.toUpperCase());
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered in determining letter index to update");
                            break;
                    }
                    letterIndex++;
                }
                break;
            case 3:
                result = word3.addLetter(letter.charAt(0));
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Each word can only have 5 letters.", "5 Letter Words Only", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    switch (letterIndex) {
                        case 0:
                            line30.setText(letter.toUpperCase());
                            break;
                        case 1:
                            line31.setText(letter.toUpperCase());
                            break;
                        case 2:
                            line32.setText(letter.toUpperCase());
                            break;
                        case 3:
                            line33.setText(letter.toUpperCase());
                            break;
                        case 4:
                            line34.setText(letter.toUpperCase());
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered in determining letter index to update");
                            break;
                    }
                    letterIndex++;
                }
                break;
            case 4:
                result = word4.addLetter(letter.charAt(0));
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Each word can only have 5 letters.", "5 Letter Words Only", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    switch (letterIndex) {
                        case 0:
                            line40.setText(letter.toUpperCase());
                            break;
                        case 1:
                            line41.setText(letter.toUpperCase());
                            break;
                        case 2:
                            line42.setText(letter.toUpperCase());
                            break;
                        case 3:
                            line43.setText(letter.toUpperCase());
                            break;
                        case 4:
                            line44.setText(letter.toUpperCase());
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered in determining letter index to update");
                            break;
                    }
                    letterIndex++;
                }
                break;
            case 5:
                result = word5.addLetter(letter.charAt(0));
                if (!result) {
                    JOptionPane.showMessageDialog(null, "Each word can only have 5 letters.", "5 Letter Words Only", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    switch (letterIndex) {
                        case 0:
                            line50.setText(letter.toUpperCase());
                            break;
                        case 1:
                            line51.setText(letter.toUpperCase());
                            break;
                        case 2:
                            line52.setText(letter.toUpperCase());
                            break;
                        case 3:
                            line53.setText(letter.toUpperCase());
                            break;
                        case 4:
                            line54.setText(letter.toUpperCase());
                            break;
                    
                        default:
                            System.out.println("Controller.java : Error Encountered in determining letter index to update");
                            break;
                    }
                    letterIndex++;
                }
                break;
        
            default:
                System.out.println("Controller.java : Error Encountered in determining guess");
                break;
        }
    }

    public void resetBoard(ActionEvent e) {
        guess = 0;
        letterIndex = 0;
        gameWordList = new wordList();
        log.logReset();
    
        word0 = new word();
        word1 = new word();
        word2 = new word();
        word3 = new word();
        word4 = new word();
        word5 = new word();

        line00.setText("");
        line01.setText("");
        line02.setText("");
        line03.setText("");
        line04.setText("");
        line10.setText("");
        line11.setText("");
        line12.setText("");
        line13.setText("");
        line14.setText("");
        line20.setText("");
        line21.setText("");
        line22.setText("");
        line23.setText("");
        line24.setText("");
        line30.setText("");
        line31.setText("");
        line32.setText("");
        line33.setText("");
        line34.setText("");
        line40.setText("");
        line41.setText("");
        line42.setText("");
        line43.setText("");
        line44.setText("");
        line50.setText("");
        line51.setText("");
        line52.setText("");
        line53.setText("");
        line54.setText("");
        
        line00.setStyle("-fx-background-color: white;");
        line01.setStyle("-fx-background-color: white;");
        line02.setStyle("-fx-background-color: white;");
        line03.setStyle("-fx-background-color: white;");
        line04.setStyle("-fx-background-color: white;");
        line10.setStyle("-fx-background-color: white;");
        line11.setStyle("-fx-background-color: white;");
        line12.setStyle("-fx-background-color: white;");
        line13.setStyle("-fx-background-color: white;");
        line14.setStyle("-fx-background-color: white;");
        line20.setStyle("-fx-background-color: white;");
        line21.setStyle("-fx-background-color: white;");
        line22.setStyle("-fx-background-color: white;");
        line23.setStyle("-fx-background-color: white;");
        line24.setStyle("-fx-background-color: white;");
        line30.setStyle("-fx-background-color: white;");
        line31.setStyle("-fx-background-color: white;");
        line32.setStyle("-fx-background-color: white;");
        line33.setStyle("-fx-background-color: white;");
        line34.setStyle("-fx-background-color: white;");
        line40.setStyle("-fx-background-color: white;");
        line41.setStyle("-fx-background-color: white;");
        line42.setStyle("-fx-background-color: white;");
        line43.setStyle("-fx-background-color: white;");
        line44.setStyle("-fx-background-color: white;");
        line50.setStyle("-fx-background-color: white;");
        line51.setStyle("-fx-background-color: white;");
        line52.setStyle("-fx-background-color: white;");
        line53.setStyle("-fx-background-color: white;");
        line54.setStyle("-fx-background-color: white;");

        aKey.setStyle("-fx-background-color: white;");
        bKey.setStyle("-fx-background-color: white;");
        cKey.setStyle("-fx-background-color: white;");
        dKey.setStyle("-fx-background-color: white;");
        eKey.setStyle("-fx-background-color: white;");
        fKey.setStyle("-fx-background-color: white;");
        gKey.setStyle("-fx-background-color: white;");
        hKey.setStyle("-fx-background-color: white;");
        iKey.setStyle("-fx-background-color: white;");
        jKey.setStyle("-fx-background-color: white;");
        kKey.setStyle("-fx-background-color: white;");
        lKey.setStyle("-fx-background-color: white;");
        mKey.setStyle("-fx-background-color: white;");
        nKey.setStyle("-fx-background-color: white;");
        oKey.setStyle("-fx-background-color: white;");
        pKey.setStyle("-fx-background-color: white;");
        qKey.setStyle("-fx-background-color: white;");
        rKey.setStyle("-fx-background-color: white;");
        sKey.setStyle("-fx-background-color: white;");
        tKey.setStyle("-fx-background-color: white;");
        uKey.setStyle("-fx-background-color: white;");
        vKey.setStyle("-fx-background-color: white;");
        wKey.setStyle("-fx-background-color: white;");
        xKey.setStyle("-fx-background-color: white;");
        yKey.setStyle("-fx-background-color: white;");
        zKey.setStyle("-fx-background-color: white;");

        aKey.setDisable(false);
        bKey.setDisable(false);
        cKey.setDisable(false);
        dKey.setDisable(false);
        eKey.setDisable(false);
        fKey.setDisable(false);
        gKey.setDisable(false);
        hKey.setDisable(false);
        iKey.setDisable(false);
        jKey.setDisable(false);
        kKey.setDisable(false);
        lKey.setDisable(false);
        mKey.setDisable(false);
        nKey.setDisable(false);
        oKey.setDisable(false);
        pKey.setDisable(false);
        qKey.setDisable(false);
        rKey.setDisable(false);
        sKey.setDisable(false);
        tKey.setDisable(false);
        uKey.setDisable(false);
        vKey.setDisable(false);
        wKey.setDisable(false);
        xKey.setDisable(false);
        yKey.setDisable(false);
        zKey.setDisable(false);
    }
}
