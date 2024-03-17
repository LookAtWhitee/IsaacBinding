package Game.Logic;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class HitIsaccSounds {
     AudioInputStream audioInputStream;
     Clip clip;

    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/Game/Sources/Sounds/hurt.wav"));
            clip = AudioSystem.getClip();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public HitIsaccSounds(){
        try{
            clip.open(audioInputStream);
            clip.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
