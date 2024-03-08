package Game.GUI;

import Game.Logic.RoomsManager;
import Game.Game;
import java.awt.*;

public class Rooms{
    public RoomsManager[][] rooms = new RoomsManager[5][5];
    int first_Room_x;
    int first_Room_y;
    int x;
    int y;

    public Rooms(){
        first_Room_x = (int)(Math.random()*5);
        first_Room_y = (int)(Math.random()*5);
        rooms[first_Room_x][first_Room_y] = new RoomsManager();
        x = first_Room_x;
        y = first_Room_y;
    }

    public void draw(Graphics g){
        g.drawImage(rooms[x][y].CurrentRoom.getImage(), Game.frame.getWidth(), Game.frame.getWidth(), 0,0,null);
        }
}
