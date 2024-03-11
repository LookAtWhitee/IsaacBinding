package Game;

import Game.GUI.Frame;
import Game.Logic.Updater;


public class Game {
     public static Frame frame;
     public static Updater update;
    public Game(){
        frame = new Frame();
        update = new Updater(frame);

        final int FPS = 60;
        final int Skip_Ticks = 1000/FPS;

        boolean Game_Running = true;

        long nextGameTick = System.currentTimeMillis();
        long sleep_time = 0;

        while (Game_Running){
            updateGame();
            displayGame();

            nextGameTick += Skip_Ticks;
            sleep_time = nextGameTick - System.currentTimeMillis();
            if (sleep_time >= 0){
                try{
                    Thread.sleep(sleep_time);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }else {
                //Tick Behind
            }
        }
    }

    private void displayGame(){
        frame.repaint();
    }

    private void updateGame(){
        update.update();
    }

}
