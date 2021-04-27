import java.util.Objects;
import greenfoot.*;

/**
 * Sound setting class using singleton pattern.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Sound  
{
    private static Sound soundInstance = null;
    private int soundOn; /* 1 for on, 0 for off */
    private GreenfootSound levelMusic = new GreenfootSound("spyhunter.wav");
    private GreenfootSound horn = new GreenfootSound("horn.wav");
    private GreenfootSound wrongMove = new GreenfootSound("wrong-move.wav");
    private GreenfootSound screech = new GreenfootSound("screech.mp3");
    private GreenfootSound breaking = new GreenfootSound("break.wav");
    
    private Sound() 
    {
        this.soundOn = 1; /* start with on */
    }
  
    public static Sound getInstance()
    {
        if (Objects.isNull(soundInstance))
            soundInstance = new Sound();
  
        return soundInstance;
    }
    
    public void playHorn()
    {
        if (soundOn == 1)
            this.horn.play();
    }
    
    public void playWrongMove()
    {
        if (soundOn == 1)
            this.wrongMove.play();
    }
    
    public void playScreech()
    {
        if (soundOn == 1)
            this.screech.play();
    }
    
    public void playLevelMusic()
    {
        if (soundOn == 1)
            this.levelMusic.play();
    }
    
    public void playBreaking()
    {
        if (soundOn == 1)
            this.breaking.play();
    }
    
    public void stopLevelMusic()
    {
        this.levelMusic.stop();
    }
    
    public boolean isSoundOn()
    {
        return this.soundOn == 1 ? true : false;
    }
    
    public void changeSoundSetting()
    {
        this.soundOn = 1 - this.soundOn;
    }
}
