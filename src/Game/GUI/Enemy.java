package Game.GUI;

import Game.GUI.Enemys.Mosca;
import Game.GUI.Enemys.Verme;
import Game.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Enemy {
    private Isaac isaac = Game.frame.getIsaac();
    public ArrayList<Object> enemy = new ArrayList<>();
    private int NumberEnemy = 2;
    public Enemy(){
        generateEnemy();
    }

    public void generateEnemy(){
        if (enemy.isEmpty()){
            for (int i = 0; i < NumberEnemy; i++) {
                int x = (int)(Math.random()*1793);
                int y = (int)(Math.random()*1009);

                if((int)(Math.random()*100)%2 == 0) {
                    enemy.add(new Mosca(x,y));
                }else {
                    enemy.add(new Verme(x,y));
                }
            }
        }
    }

    public void move(){
        if(!enemy.isEmpty()){
            for (Object en : enemy){
                if (en instanceof Mosca){
                    ((Mosca) en).move();
                } else if (en instanceof Verme) {
                    ((Verme) en).move();
                }
            }
        }
    }

    public void draw(Graphics g){
        if(!enemy.isEmpty()){
            for (Object en : enemy){
                if (en instanceof Mosca){
                    ((Mosca) en).draw(g);
                } else if (en instanceof Verme) {
                    ((Verme) en).draw(g);
                }
            }
        }
    }

    public boolean checkHit(){
        return false;
    }
}
