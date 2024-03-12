package Game.GUI.Enemys;

import Game.GUI.Isaac;
import Game.Game;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

public class Mosca extends Rectangle {
    ImageIcon mosca = new ImageIcon("src/Game/Sources/Enemy/Mosca.png");
    private Isaac isaac = Game.frame.panel.isaac;
    private int Life = 3;
    public boolean removeLife(){
        Life--;
        if (Life == 0){
            return true;
        }

        return false;
    }

    private int Movement_Speed = 2;
    public Mosca(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 60;
    }

    public void draw(Graphics g){
        g.drawImage(mosca.getImage(), x, y, width, height, null);
    }

    public void move(){
        if(x > isaac.x){
            x -= Movement_Speed;
        }else if (x < isaac.x){
            x += Movement_Speed;
        }

        if (y > isaac.y){
            y -= Movement_Speed;
        }else if (y < isaac.y){
            y += Movement_Speed;
        }
    }



}
