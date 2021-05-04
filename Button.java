import greenfoot.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Write a description of class Button here.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Button extends Actor
{
    
    private String button;
    
    public Button(String button)
    {
        this.button = button;
        
        setImage(button + ".png");
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this))
        {
            if (button.equals("sound"))
            {
                Sound.getInstance().changeSoundSetting();
                setImage(new GreenfootImage(Sound.getInstance().isSoundOn() ? "sound.png" : "soundoff.png"));
            }
            else if (button.equals("info"))
            {
                try {
                    getWorld().addObject(new InfoMessage(Files.readString(Paths.get("./gameinfo.txt"), StandardCharsets.US_ASCII)), getWorld().getWidth()/2, getWorld().getHeight()/2);
                } catch(IOException e) {}
            }
            else if (button.equals("settings"))
            {
                Greenfoot.setWorld(new SettingsUI());
            }
            else if (button.equals("ok"))
            {
                Greenfoot.setWorld(new MainMenu());
            }
            else
                if (!button.contains("disabled"))
                    Greenfoot.setWorld(new MyWorld(Integer.parseInt(button.substring(button.length()-1))));
         }
    }    
}
