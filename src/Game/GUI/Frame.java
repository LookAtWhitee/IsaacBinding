package Game.GUI;

import javax.swing.*;

public class Frame extends JFrame {
    public Isaac isaac;
    public Pannel panel;

    public Frame(){
        super();
        setSize(1792, 1008);
        setTitle("Isaac Binding");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setPanel(Pannel panel){
        this.panel = panel;
    }
    public void setIsaac(Isaac isaac){
        this.isaac = isaac;
    }

    public Isaac getIsaac(){
        return isaac;
    }
}
