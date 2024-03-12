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
import java.util.ArrayList;

public class Updater {
    private final int Movement_Speed = 5;
    private final long invulnerability = 5000;
    public static ArrayList<Shoot> shoots = new ArrayList<>();

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
        for (int i = 0; i < shoots.size(); i++) {
            if(!shoots.get(i).moveShot()){
                for(int j = 0; j < Enemy.enemy.size(); j++) {
                    if (Enemy.enemy.get(j) instanceof Mosca) {
                        if (shoots.get(i).intersects((Rectangle) Enemy.enemy.get(j))) {
                            shoots.remove(i);
                            if (((Mosca) Enemy.enemy.get(j)).removeLife()){
                                Enemy.enemy.remove(j);
                            }
                            break;
                        }
                    } else if (Enemy.enemy.get(j) instanceof Verme) {
                        if (shoots.get(i).intersects((Rectangle) Enemy.enemy.get(j))) {
                            shoots.remove(i);
                            if (((Verme) Enemy.enemy.get(j)).removeLife()){
                                Enemy.enemy.remove(j);
                            }
                        }
                    }
                }
            }else{
                shoots.remove(i);
            }
        }
    }

    public static void shoot(Isaac isaac){
        shoots.add(new Shoot(isaac));

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
                break;
            case Direction.Down:
                if(((isaac.y + Movement_Speed) <= 750)){
                    isaac.y += Movement_Speed;
                }
                break;
            case Direction.Left:
                if ((isaac.x - Movement_Speed) >= 170){
                    isaac.x -= Movement_Speed;
                }
                break;
            case Direction.Right:
                if ((isaac.x + Movement_Speed) <= 1525){
                    isaac.x += Movement_Speed;
                }
                break;
        }
    }
}
