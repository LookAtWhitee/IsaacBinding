package Game.GUI;

import Game.Game;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame getInstance(){
        return this;
    }
    Rooms bg;
    public Frame(){
        super();
        setSize((int)(getToolkit().getScreenSize().getWidth()*0.6),
                (int)(getToolkit().getScreenSize().getHeight()*0.6));
        setTitle("Isaac Binding");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

//    @Override
//    public void paint(Graphics g){
//        bg.draw(g);
//        g.drawImage(new ImageIcon("C:\\Users\\tommy\\IdeaProjects\\Game\\src\\Game\\Img\\Rooms\\Themeplate_Rooms.png").getImage(), Game.frame.getWidth(), Game.frame.getWidth(), 0, 0, null);
//    }
}
