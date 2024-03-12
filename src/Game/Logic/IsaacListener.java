package Game.Logic;

import Game.GUI.Isaac;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class IsaacListener implements KeyListener {
    public Isaac isaac;
    private static ArrayList<Character> key = new ArrayList<>();
    public IsaacListener(Isaac isaac){
        //Work in Progress
        this.isaac = isaac;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        synchronized (key){
            if(!key.contains(e.getKeyChar())){
                key.add(e.getKeyChar());
                switch(e.getKeyChar()){
                    case 'w': isaac.currentDirection = Direction.Up; isaac.lastDirection = Direction.Up; break;
                    case 's': isaac.currentDirection = Direction.Down; isaac.lastDirection = Direction.Down; break;
                    case 'a': isaac.currentDirection = Direction.Left; isaac.lastDirection = Direction.Left; break;
                    case 'd': isaac.currentDirection = Direction.Right; isaac.lastDirection = Direction.Right; break;
                    case ' ': Updater.shoot(isaac); break;
                    default: isaac.currentDirection = Direction.Still; break;
                }
            }
        }
    }
    @SuppressWarnings("removal")
    @Override
    public void keyReleased(KeyEvent e) {
        synchronized (key){
            if(key.contains(e.getKeyChar())){
                key.remove(new Character(e.getKeyChar()));
            }
            if (key.isEmpty()){
                isaac.currentDirection = Direction.Still;
            }
        }
    }
}
