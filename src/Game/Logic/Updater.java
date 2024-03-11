package Game.Logic;

import Game.GUI.Frame;
import Game.GUI.Isaac;
import Game.GUI.Pannel;

public class Updater {
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
            case Direction.Up: isaac.y -= 1; break;
            case Direction.Down: isaac.y += 1; break;
            case Direction.Left: isaac.x -= 1; break;
            case Direction.Right: isaac.x += 1; break;
        }
    }
}
