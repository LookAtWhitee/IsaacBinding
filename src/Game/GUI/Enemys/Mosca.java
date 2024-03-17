package Game.GUI.Enemys;

import Game.GUI.Isaac;
import Game.Game;
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

public class Mosca extends Rectangle {
    ImageIcon mosca = new ImageIcon("src/Game/Sources/Enemy/Mosca.png");
    private Isaac isaac = Game.frame.panel.isaac;
    private int Movement_Speed = 13;
    private int Life = 3;

    public boolean removeLife() {
        Life--;
        if (Life == 0) {
            return true;
        }

        return false;
    }


    public Mosca(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 60;
        this.height = 60;
    }

    public void draw(Graphics g) {
        g.drawImage(mosca.getImage(), x, y, width, height, null);
    }

    public void move() {
        if (x > isaac.x) {
            if (isaac.x % x == 0 ) {
                if (!this.intersects(isaac)){
                    x -= Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    x -= 1;
                }
            }
        } else if (x < isaac.x) {
            if (isaac.x % x == 0) {
                if (!this.intersects(isaac)){
                    x += Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    x += 1;
                }
            }
        } else if (y > isaac.y) {
            if (isaac.y % y == 0) {
                if (!this.intersects(isaac)){
                    y -= Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    y -= 1;
                }
            }
        } else if (y < isaac.y) {
            if (isaac.y % y == 0) {
                if (!this.intersects(isaac)){
                    y += Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    y += 1;
                }
            }
        }
    }

}




