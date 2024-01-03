package MatchGame;

import javax.swing.*;
import java.awt.*;

public class Game_2 extends JFrame {
    private Setting setting;
    private JFrame jFrame;

    public Game_2() {
//        super("Match Game");
        setting = new Setting(new Rectangle(550, 200, 50, 20), new Rectangle(450, 450, 50, 50), new Rectangle(550, 250, 50, 20),this);
        setting.setPreferredSize(new Dimension(960, 540));
        setVisible(true);
        getContentPane().add(setting, BorderLayout.CENTER);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(Constant.TITLE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}