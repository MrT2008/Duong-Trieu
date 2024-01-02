package MatchGame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Setting extends JPanel implements MouseListener, MouseMotionListener {
    private BufferedImage noClickSettingImage, clickBackSetting, clickBackgroundOn;
    JFrame frame;
    private boolean isClicked;
    private Point mousePos = new Point(-1, -1);
    private Rectangle area, area2, area3;
    private int state, back, backgroundOn;

    public Setting(Rectangle area, Rectangle area2, JFrame jFrame) {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.area=area;
        this.frame=jFrame;
        this.area2=area2;
        // this.area3 = area3;
        state=1;
        back=2;
        backgroundOn=3;

        // Load the background image
        try {
            noClickSettingImage=ImageIO.read(getClass().getResourceAsStream("/res/no click setting (2).png"));
            clickBackgroundOn=ImageIO.read(getClass().getResourceAsStream("/res/backgroundOn.png"));
            clickBackSetting=ImageIO.read(getClass().getResourceAsStream("/res/clickBackSetting.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent e) {
        // Do nothing
    }

    public void mousePressed(MouseEvent e) {
        if (area2.contains(e.getPoint())) {
            handleMouseEvent(e);
        }
        // } else if (area2.contains(e.getPoint())) {
        //     System.exit(0);
        // }
    }
    public void handleMouseEvent(MouseEvent e) {
        frame.dispose();
        backToMain();
    }
    private void backToMain() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new CandyCrush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
    public void mouseReleased(MouseEvent e) {
        isClicked = false;
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    public void mouseExited(MouseEvent e) {
        // Do nothing
    }

    public void mouseMoved(MouseEvent e) { 
        Point point = e.getPoint();
        if (area.contains(point)) {
            state=backgroundOn;
            repaint();
        } else if (area2.contains(point)) {
            state=back;
            repaint();
        // } else if(area3.contains(point)){   
        //     state=setting;
        //     repaint();
        } else{
            state=1;
            repaint();
        }
    }
    public void mouseDragged(MouseEvent e) {
        mousePos = e.getPoint();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(state==1) {
            g.drawImage(noClickSettingImage, 0, 0, getWidth(), getHeight(), this);
        }
        if(state==back){
            g.drawImage(clickBackSetting, 0, 0, getWidth(), getHeight(), this);
        }
        if(state==backgroundOn){
            g.drawImage(clickBackgroundOn, 0, 0, getWidth(), getHeight(), this);
        }
    }


}

