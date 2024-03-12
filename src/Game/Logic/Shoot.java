package Game.Logic;

import Game.GUI.Isaac;

import javax.swing.*;
import java.awt.*;

public class Shoot extends Rectangle {
    final private int ShootSpeed = 8;
    Direction direction;
    Isaac isaac;
    ImageIcon shootImg = new ImageIcon("src/Game/Sources/Misc/Shoot.png");

    public Shoot(Isaac isaac) {
        this.isaac = isaac;
        direction = isaac.lastDirection;
        x = isaac.x;
        y = isaac.y;
        height = 30;
        width = 30;
    }

    public boolean moveShot() {
        switch (direction) {
            case Still:
                break;
            case Direction.Up:
                if ((y - ShootSpeed) >= 80) {
                    y -= ShootSpeed;
                    return false;
                } else {
                    return true;
                }

            case Direction.Down:
                if (((y + ShootSpeed) <= 750)) {
                    y += ShootSpeed;
                    return false;
                } else {
                    return true;
                }

            case Direction.Left:
                if ((x - ShootSpeed) >= 170) {
                    x -= ShootSpeed;
                    return false;
                } else {
                    return true;
                }


            case Direction.Right:
                if ((x + ShootSpeed) <= 1525) {
                    x += ShootSpeed;
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }


    public void draw(Graphics g) {
        g.drawImage(shootImg.getImage(), x, y, width, height, null);
    }
}
