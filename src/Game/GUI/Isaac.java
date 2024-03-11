package Game.GUI;

import Game.Logic.Direction;

import javax.swing.*;
import java.awt.*;

public class Isaac {
    ImageIcon IsaacFront = new ImageIcon("src/Game/Img/IsaacFront.png");
    ImageIcon IsaacBack = new ImageIcon("src/Game/Img/IsaacBack.png");
    ImageIcon IsaacLeft = new ImageIcon("src/Game/Img/IsaacLeft.png");
    ImageIcon IsaacRight = new ImageIcon("src/Game/Img/IsaacRight.png");
    ImageIcon currentView = IsaacFront;
    public Direction currentDirection = Direction.Still;
    public int x;
    public int y;
    public Isaac(){
        x = 500;
        y = 500;
    }

    public void draw(Graphics g){
        g.drawImage(currentView.getImage(), x,y,100,100, null);
    }
}
