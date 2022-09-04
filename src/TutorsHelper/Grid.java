package TutorsHelper;

import javax.swing.*;
import java.awt.*;
import static TutorsHelper.Libs.*;

public class Grid {
    private static JLabel winnerState, lastScoredState, scoreState;
    private static JButton realBtn, madridBtn;
    public static void UpdateWinner() {
        winnerState.setText("Winner: " + GetWinner());
    }
    public static void UpdateLastScored() {
        lastScoredState.setText("Last scored: " + lastScored);
    }
    public static void UpdateScore() {
        scoreState.setText("AC Real " + realScore + ":" + madridScore + "  Madrid");
    }

    public Grid() {};
    static void setGrid() {
        winnerState = Elements.newLabel("Winner: DRAW",
                new Dimension(300, 40),20);
        VerticalAlign(winnerState, "top");
        winnerState.setLocation(winnerState.getX(), winnerState.getY() + 30);


        lastScoredState = Elements.newLabel("Last Scored: --",
                new Dimension(200, 34),16);
        VerticalAlign(lastScoredState, "under", winnerState);
        lastScoredState.setLocation(lastScoredState.getX(), lastScoredState.getY() + 5);


        scoreState = Elements.newLabel("AC Real 0:0  Madrid",
                new Dimension(400, 150),32);
        VerticalAlign(scoreState, "under", lastScoredState);
        scoreState.setLocation(scoreState.getX(), scoreState.getY() + 15);


        realBtn = Elements.newButton("++Real",
                new Dimension(120, 45), 20, scoreState);
        realBtn.setLocation(realBtn.getX() - 80, realBtn.getY() + 20);


        madridBtn = Elements.newButton("++Madrid",
                new Dimension(120, 45), 20, scoreState);
        madridBtn.setLocation(madridBtn.getX() + 80, madridBtn.getY() + 20);
    }
}
