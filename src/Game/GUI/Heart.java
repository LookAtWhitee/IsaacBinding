package Game.GUI;

import javax.management.ListenerNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Heart {
    final int heartCount = 3;
    ImageIcon Heart = new ImageIcon("src/Game/Sources/Heart.png");
    ArrayList<ImageIcon> heart = new ArrayList<>();
    public Heart(){
        for (int i = 0; i < heartCount; i++) {
            heart.add(Heart);
        }
    }

    public int getHeartCount(){
        return heart.size();
    }
    public void removeHeart(){
        heart.removeLast();
    }

    public void addHeart(){
        heart.add(Heart);
    }
    public void draw(Graphics g){
        int x = 20;
        for (int i = 0; i < heart.size(); i++) {
            g.drawImage(heart.get(i).getImage(), x, 20, 50,50, null);
            x += 50;
        }
    }
}
