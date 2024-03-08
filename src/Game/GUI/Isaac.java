package Game.GUI;

import javax.swing.*;
import java.awt.*;

public class Isaac {
    ImageIcon Isaac = new ImageIcon("src/Game/Img/IsaacFront.png");
    public Isaac(){
    }

    public void draw(Graphics g){
        g.drawImage(Isaac.getImage(), 70,70,500,500, null);
    }
}
