package Game.GUI;

import Game.Logic.Direction;
import Game.Logic.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Isaac extends Rectangle{
    ImageIcon IsaacFront = new ImageIcon("src/Game/Sources/Isaac/IsaacFront.png");
    ImageIcon IsaacBack = new ImageIcon("src/Game/Sources/Isaac/IsaacBack.png");
    ImageIcon IsaacLeft = new ImageIcon("src/Game/Sources/Isaac/IsaacLeft.png");
    ImageIcon IsaacRight = new ImageIcon("src/Game/Sources/Isaac/IsaacRight.png");
    ImageIcon currentView = IsaacFront;
    public Direction currentDirection = Direction.Still;
    public Direction lastDirection = Direction.Down;
    public State state = State.Alive;
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
