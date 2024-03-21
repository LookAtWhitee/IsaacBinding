package Game.GUI.Enemys;

import Game.GUI.Isaac;
import Game.Game;

import javax.swing.*;
import java.awt.*;

public class Verme extends Rectangle {
    ImageIcon verme = new ImageIcon("src/Game/Sources/Enemy/Verme.png");
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

    public Verme(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 50;
    }

    public void draw(Graphics g) {
        g.drawImage(verme.getImage(), x, y, width, height, null);
    }

    public void move() {
        if (x > isaac.x) {
            if (isaac.x % (x+1) == 0 ) {
                if (!this.intersects(isaac)){
                    x -= Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    x -= 1;
                }
            }
        } else if (x < isaac.x) {
            if (isaac.x % (x+1) == 0) {
                if (!this.intersects(isaac)){
                    x += Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    x += 1;
                }
            }
        } else if (y > isaac.y) {
            if (isaac.y % (y+1) == 0) {
                if (!this.intersects(isaac)){
                    y -= Movement_Speed;
                }
            } else {
                if (!this.intersects(isaac)){
                    y -= 1;
                }
            }
        } else if (y < isaac.y) {
            if (isaac.y % (y+1) == 0) {
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
