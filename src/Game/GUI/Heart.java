package Game.GUI;

import javax.management.ListenerNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Heart {
    ImageIcon Heart = new ImageIcon("src/Game/Img/Heart.png");
    ArrayList<ImageIcon> heart = new ArrayList<>();
    public Heart(){
        for (int i = 0; i < 3; i++) {
            heart.add(Heart);
        }
    }

    private void removeHeart(){
        heart.removeLast();
    }

    private void addHeart(){
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
