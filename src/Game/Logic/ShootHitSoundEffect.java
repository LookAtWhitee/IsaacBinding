package Game.Logic;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class ShootHitSoundEffect {
    AudioInputStream audioInputStream;
    Clip clip;

    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("src/Game/Sources/Sounds/TearImpacts0.wav"));
            clip = AudioSystem.getClip();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ShootHitSoundEffect(){
        try {
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void stop(){
        clip.stop();
    }
}
