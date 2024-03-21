package Game.GUI;

import Game.GUI.Enemys.Mosca;
import Game.GUI.Enemys.Verme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateEnemy implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
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
