package Game.GUI;

import Game.Game;
import Game.Logic.IsaacListener;

import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {
    public Rooms room;
    public Isaac isaac;
    public Pannel(Frame frame){
        super();
        room = new Rooms();
        isaac = new Isaac();
        frame.add(this);
        frame.addKeyListener(new IsaacListener(isaac));
    }

    @Override
    public void paint(Graphics g){
        room.draw(g);
        isaac.draw(g);
        }
}
