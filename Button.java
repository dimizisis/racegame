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
            else if (button.startsWith("categories_btn_"))
            {
                Greenfoot.setWorld(new CategoriesMenu());
            }
            else if (button.startsWith("stats_btn_"))
            {
                // TODO
            }
            else if (button.startsWith("exit_btn_"))
            {
                Greenfoot.stop();
            }
            else if (button.startsWith("back_btn_"))
            {
                Greenfoot.setWorld(new MainMenu());
            }
            else if (button.startsWith("crossings_btn_"))
            {
                Greenfoot.setWorld(new MyWorld("crossings"));
            }
<<<<<<< Updated upstream
=======
            else if (button.startsWith("speed_limits_btn_"))
            {
                Greenfoot.setWorld(new MyWorld("speed_limits"));
            }
>>>>>>> Stashed changes
         }
    }    
}
