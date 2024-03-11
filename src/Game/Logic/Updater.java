package Game.Logic;

import Game.GUI.Frame;
import Game.GUI.Isaac;
import Game.GUI.Pannel;

public class Updater {
    public static Double move = 0.00;
    public Isaac isaac;
    public Updater(Frame frame){
        Pannel pane = new Pannel(frame);
        isaac = frame.getIsaac();
    }

    public void update(){
        movement();
    }


    private void movement(){

        switch(isaac.currentDirection){
            case Direction.Up: isaac.y -= (int)(1 + move); move += 0.05; break;
            case Direction.Down: isaac.y += (int)(1 + move); move += 0.05; break;
            case Direction.Left: isaac.x -= (int)(1 + move); move += 0.05; break;
            case Direction.Right: isaac.x += (int)(1 + move); move += 0.05; break;
        }
    }
}
