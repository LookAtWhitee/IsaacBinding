package Game.Logic;

import Game.GUI.Enemy;
import Game.GUI.Enemys.Mosca;
import Game.GUI.Enemys.Verme;
import Game.GUI.Frame;
import Game.GUI.Isaac;
import Game.GUI.Pannel;
import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Updater {
    private final int Movement_Speed = 5;
    private final long invulnerability = 5000;

    public Isaac isaac;
    public Updater(Frame frame){
        Ost ost = new Ost();
        Pannel pane = new Pannel(frame);
        isaac = frame.getIsaac();

    }

    public void update(){
        movement();
        Game.frame.panel.room.enemyList.move();
        checkHit();
    }

    static boolean timer = true;
    public void checkHit() {
        boolean flag = false;
        for (int i = 0; i < Enemy.enemy.size(); i++) {
            if (Enemy.enemy.get(i) instanceof Mosca || Enemy.enemy.get(i) instanceof Verme){
                if (isaac.intersects((Rectangle) Enemy.enemy.get(i))){
                    flag = true;
                }
            }
        }

        if (flag){
            Timer t = new Timer(5000, new HitCD());
            if(timer){
                Game.frame.getPanel().getHeart().removeHeart();
                timer = false;
                flag = false;
                t.start();
            }else{
                t.stop();
            }

        }
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
