package Game.Logic;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Ost {
    AudioInputStream audioInputStream;
    Clip clip;

    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/Game/Sources/The-binding-of-Isaac-OST-Basement-theme.wav"));
            clip = AudioSystem.getClip();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public Ost(){
        try {
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
