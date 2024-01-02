 package MatchGame;

import javax.swing.*;
import java.awt.*;

/**
 * Match Game
 * Author: Peter Mitchell (2021)
 *
 * Game class:
 * Entry point for creating the GUI and
 * associated panels. Also acts as the
 * inbetween point for communication between panels.
 */
public class Game extends JFrame {
    /**
     * Reference to the MatchPanel object to apply the restart action.
     */
    private MatchPanel matchPanel;
    /**
     * Reference to the StatusPanel object to apply restarts and update score visuals.
     */
    private StatusPanel statusPanel;

    /**
     * Creates the JFrame, and the two panels then adds them and
     * makes the frame visible.
     */
    public Game() {
        super("Match Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        matchPanel = new MatchPanel(8,8, this);
        getContentPane().add(matchPanel);
        statusPanel = new StatusPanel(this, 20*32);
        getContentPane().add(statusPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void notifyScoreUpdate(int newScore, int scoreDelta) {
        statusPanel.updateScore(newScore, scoreDelta);
    }

    public void restart() {
        statusPanel.updateScore(0,0);
        matchPanel.restart();
    }
}
