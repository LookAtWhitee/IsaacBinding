package Game.GUI.Enemys;

import Game.GUI.Isaac;
import Game.Game;

import javax.swing.*;
import java.awt.*;

public class Verme extends Rectangle {
    ImageIcon verme = new ImageIcon("src/Game/Img/Enemy/Verme.png");
    private Isaac isaac = Game.frame.panel.isaac;
    private int Movement_Speed  = 2;
    public Verme(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 50;
    }

    public void draw(Graphics g){
        g.drawImage(verme.getImage(), x, y, width, height, null);
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
