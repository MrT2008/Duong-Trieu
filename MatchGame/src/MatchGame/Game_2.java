package MatchGame;

import javax.swing.*;
import java.awt.*;

public class Game_2 extends JFrame {
    private Setting setting;

    public Game_2() {
        super("Match Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setting = new Setting(new Rectangle(550, 200, 50, 20), new Rectangle(450, 450, 50, 50), this);
        setting.setPreferredSize(new Dimension(960, 540));
        getContentPane().add(setting, BorderLayout.NORTH);
        setResizable(false);
        // setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}