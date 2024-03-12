package Game.GUI;

import Game.Logic.RoomsManager;
import Game.Game;
import java.awt.*;

public class Rooms{
    public RoomsManager rooms;
    public Enemy enemyList;


    public Rooms(){
        rooms = new RoomsManager();
        enemyList = new Enemy();
    }

    public void draw(Graphics g){
        g.drawImage(rooms.CurrentRoom.getImage(), 0, 0, Game.frame.getWidth(),Game.frame.getHeight(),null);
        }
}
