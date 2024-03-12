package Game.GUI;

import Game.Logic.Direction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Isaac extends Rectangle{
    ImageIcon IsaacFront = new ImageIcon("src/Game/Img/Isaac/IsaacFront.png");
    ImageIcon IsaacBack = new ImageIcon("src/Game/Img/Isaac/IsaacBack.png");
    ImageIcon IsaacLeft = new ImageIcon("src/Game/Img/Isaac/IsaacLeft.png");
    ImageIcon IsaacRight = new ImageIcon("src/Game/Img/Isaac/IsaacRight.png");
    ImageIcon currentView = IsaacFront;
    public Direction currentDirection = Direction.Still;
    public Isaac(){
        super();
        this.x = 500;
        this.y = 500;
        this.width = 100;
        this.height = 100;
    }

    public void draw(Graphics g){
        switch (currentDirection){
            case Up -> currentView = IsaacBack;
            case Down -> currentView = IsaacFront;
            case Left -> currentView = IsaacLeft;
            case Right -> currentView = IsaacRight;
            default -> {
                break;
            }
        }


        g.drawImage(currentView.getImage(), this.x, this.y, this.width, this.height, null);
    }
}
