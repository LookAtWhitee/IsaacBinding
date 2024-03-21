package Game.GUI;

import Game.GUI.Enemys.Mosca;
import Game.GUI.Enemys.Verme;
import Game.Game;
import Game.Logic.HitCD;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Enemy {
    private Isaac isaac = Game.frame.getIsaac();
    public static ArrayList<Object> enemy = new ArrayList<>();

    static Timer t;
    static int tempo = 5000;
    public Enemy() {
        t = new Timer(tempo, new GenerateEnemy());
        t.start();
        for (int i = 0; i < 2; i++) {
            int x = 0;
            int y = 0;

            int z = (int)(Math.random()*81);
            if (z%4 == 0){
                x = (int) (Math.random() * 1793);
                y = 0;
            } else if (z%4 == 1){
                x = (int) (Math.random() * 1793);
                y = 1008;
            } else if (z%4 == 2) {
                x = 0;
                y = (int) (Math.random() * 1009);
            } else if (z%4 == 3) {
                x = 1792;
                y = (int) (Math.random() * 1009);
            }

            System.out.println(x + " " + y);
            if ((int) (Math.random() * 100) % 2 == 0) {
                Enemy.enemy.add(new Mosca(x, y));
            } else {
                Enemy.enemy.add(new Verme(x, y));
            }
        }
    }

    public static void updateTimer(){
        tempo -= 5;
        t.setDelay(tempo);
        t.stop();
        t.start();
    }

    public void move() {
        if (!enemy.isEmpty()) {
            for (Object en : enemy) {
                if (en instanceof Mosca) {
                    ((Mosca) en).move();
                } else if (en instanceof Verme) {
                    ((Verme) en).move();
                }
            }
        }
    }


    public void draw(Graphics g) {
        if (!enemy.isEmpty()) {
            for (Object en : enemy) {
                if (en instanceof Mosca) {
                    ((Mosca) en).draw(g);
                } else if (en instanceof Verme) {
                    ((Verme) en).draw(g);
                }
            }
        }
    }

}
