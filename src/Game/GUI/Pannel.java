package Game.GUI;

import Game.Game;
import Game.Logic.IsaacListener;

import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {
    public Rooms room;
    public Isaac isaac;
    public Heart heart;
    public Pannel(Frame frame){
        super();
        isaac = new Isaac();
        frame.setIsaac(isaac);
        frame.setPanel(this);
        room = new Rooms();
        heart = new Heart();
        frame.add(this);
        frame.addKeyListener(new IsaacListener(isaac));
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        room.draw(g);
        isaac.draw(g);
        heart.draw(g);
        room.enemyList.draw(g);
        }
}
