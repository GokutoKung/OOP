package Sound;

import Map.*;
import java.io.File;
import javax.sound.sampled.*;


public class Sound {
    private Clip c;
    private AudioInputStream ais;
    private File sound1, sound2;

    public Sound() {
        sound1 = new File("sound/attack.wav");
        sound2 = new File("sound/heal.wav");
    }
    
    public void loadSound(int i){
        try{
            if(i == 1){
                ais = AudioSystem.getAudioInputStream(sound1);
            }
            else if(i == 2){
                ais = AudioSystem.getAudioInputStream(sound2);
            }
            c = AudioSystem.getClip();
            c.open(ais);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void play(){
        c.start();
    }
    
    public void loop(){
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop(){
        c.stop();
    }
    
    public void attackMonster(){
        loadSound(1);
        play();
    }
    
    public void heal(){
        loadSound(2);
        play();
    }

}
