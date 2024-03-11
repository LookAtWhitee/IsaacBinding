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
        room = new Rooms();
        isaac = new Isaac();
        heart = new Heart();
        frame.setIsaac(isaac);
        frame.add(this);
        frame.addKeyListener(new IsaacListener(isaac));
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        room.draw(g);
        isaac.draw(g);
        heart.draw(g);
        }
}
