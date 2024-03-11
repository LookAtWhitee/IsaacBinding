package Game.Logic;

import Game.GUI.Frame;
import Game.GUI.Isaac;
import Game.GUI.Pannel;
import Game.Game;

public class Updater {
    private final int Movement_Speed = 5;

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
            case Direction.Up:
                if ((isaac.y - Movement_Speed) >= 80){
                    isaac.y -= Movement_Speed;
                }
                System.out.println("x: " + isaac.x + "; y: " + isaac.y);
                break;
            case Direction.Down:
                if(((isaac.y + Movement_Speed) <= 750)){
                    isaac.y += Movement_Speed;
                }
                System.out.println("x: " + isaac.x + "; y: " + isaac.y);
                break;
            case Direction.Left:
                if ((isaac.x - Movement_Speed) >= 170){
                    isaac.x -= Movement_Speed;
                }
                System.out.println("x: " + isaac.x + "; y: " + isaac.y);
                break;
            case Direction.Right:
                if ((isaac.x + Movement_Speed) <= 1525){
                    isaac.x += Movement_Speed;
                }
                System.out.println("x: " + isaac.x + "; y: " + isaac.y);
                break;
        }
    }
}
