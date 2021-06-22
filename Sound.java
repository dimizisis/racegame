import java.util.Objects;
import greenfoot.*;

/**
 * Class that holds the game's data about sound.
 * It is created using the Singleton Pattern.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Sound  
{
    private static Sound soundInstance = null;
    private int soundOn; /* 1 for on, 0 for off */
    private GreenfootSound horn = new GreenfootSound("horn.wav");
    private GreenfootSound wrongMove = new GreenfootSound("wrong-move.wav");
    private GreenfootSound breaking = new GreenfootSound("break.wav");
    private GreenfootSound wellDone = new GreenfootSound("well_done.wav");
    
    /**
     * Constructor for object of class Sound.
     * Cannot be called outside the instance.
     * Default state is on.
     */
    private Sound() 
    {
        this.soundOn = 1; /* start with off */
    }
    
    /**
     * Returns the (only) instance of class Sound.
     * 
     * @return  the instance of class Sound
     */
    public static Sound getInstance()
    {
        if (Objects.isNull(soundInstance))
            soundInstance = new Sound();
  
        return soundInstance;
    }
    
    /**
     * Plays the horn sound, if sound is set on.
     */
    public void playHorn()
    {
        if (isSoundOn())
            this.horn.play();
    }
    
    /**
     * Plays the breaking sound, if sound is set on.
     */
    public void playBreaking()
    {
        if (isSoundOn())
            this.breaking.play();
    }
    
    /**
     * Plays the well done sound, if sound is set on.
     */
    public void playWellDone()
    {
        if (isSoundOn())
            this.wellDone.play();
    }
    
    /**
     * Checks if sound is on.
     * 
     * @return true if sound is on, false otherwise.
     */
    public boolean isSoundOn()
    {
        return this.soundOn == 1 ? true : false;
    }
    
    /**
     * Toggles the sound setting (on to off and vice versa).
     */
    public void changeSoundSetting()
    {
        this.soundOn = 1 - this.soundOn;
    }
}
