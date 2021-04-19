import java.util.Objects;

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
    
    private Sound() 
    {
        soundOn = 1; /* start with on */
    }
  
    public static Sound getInstance()
    {
        if (Objects.isNull(soundInstance))
            soundInstance = new Sound();
  
        return soundInstance;
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
