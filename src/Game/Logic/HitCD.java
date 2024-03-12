package Game.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HitCD implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Updater.timer = true;
    }
}
