package Game.GUI;

import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class DeathScreen extends JPanel {
    private Isaac isaac = Game.frame.getIsaac();
    public int points = 0;
    public JLabel pointsLabel;
    public JLabel gameOverLabel;
    public JButton close;

    public DeathScreen() {
        setBackground(new Color(0, 0, 0, 31)); // Sfondo parzialmente trasparente

        gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameOverLabel.setForeground(Color.WHITE);

        close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.frame.dispatchEvent(new WindowEvent(Game.frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        pointsLabel = new JLabel("Points: " + points);
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pointsLabel.setForeground(Color.WHITE);

    }

    public void refreshPoints(){
        pointsLabel = new JLabel("Points: " + points);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(100, 0, 20, 0);
        add(gameOverLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(pointsLabel, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(50, 0, 0, 0);
        add(close, gbc);
    }
}