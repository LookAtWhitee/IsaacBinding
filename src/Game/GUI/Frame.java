package Game.GUI;

import javax.swing.*;

public class Frame extends JFrame {
    public Isaac isaac;

    public Frame(){
        super();
        setSize((int)(getToolkit().getScreenSize().getWidth()*0.6),
                (int)(getToolkit().getScreenSize().getHeight()*0.6));
        setTitle("Isaac Binding");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setIsaac(Isaac isaac){
        this.isaac = isaac;
    }

    public Isaac getIsaac(){
        return isaac;
    }
}
