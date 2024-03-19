package Game.GUI;

import Game.Game;
import Game.Logic.IsaacListener;
import Game.Logic.Shoot;
import Game.Logic.State;
import Game.Logic.Updater;

import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {
    public Rooms room;
    public Isaac isaac;
    public Heart heart;
    private Frame frame;

    public Pannel(Frame frames){
        super();
        this.frame = frames;
        isaac = new Isaac();
        frame.setIsaac(isaac);
        frame.setPanel(this);
        room = new Rooms();
        heart = new Heart();
        frame.add(this);
        frame.addKeyListener(new IsaacListener(isaac));
        frame.setVisible(true);

    }

    public Heart getHeart(){
        return heart;
    }

    @Override
    public void paint(Graphics g){
        room.draw(g);
        isaac.draw(g);
        heart.draw(g);
        room.enemyList.draw(g);
        for (Shoot shoot : Updater.shoots){
            shoot.draw(g);
        }
    }
}
