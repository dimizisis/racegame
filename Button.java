import greenfoot.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Class that represents each button of the game.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Button extends Actor
{
    
    private String button;
    
    /**
     * Constructor for objects of class Button.
     * @param button  the name of the button
     */
    public Button(String button)
    {
        this.button = button;
        if (button.startsWith("information_"))
            setImage("info" + ".png");
        else
            setImage(button + ".png");
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
                Greenfoot.setWorld(new AboutMenu());
            }
            else if (button.equals("settings"))
            {
                Greenfoot.setWorld(new SettingsMenu());
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
                Greenfoot.setWorld(new StatisticsMenu());
            }
            else if (button.startsWith("exit_btn_"))
            {
                Greenfoot.stop();
            }
            else if (button.startsWith("back_btn_"))
            {
                if (this.getWorld().getClass().equals(InformationWindow.class))
                    Greenfoot.setWorld(new CategoriesMenu());
                else
                    Greenfoot.setWorld(new MainMenu());
            }
            else if (button.startsWith("crossings_btn_"))
            {
                Greenfoot.setWorld(new MyWorld("crossings"));
            }
            else if (button.startsWith("speed_limits_btn_"))
            {
                Greenfoot.setWorld(new MyWorld("speed_limits"));
            }
            else if (button.startsWith("stop_sign_btn_"))
            {
                Greenfoot.setWorld(new MyWorld("stop_sign"));
            }
            else if (button.startsWith("information_"))
            {
                if (button.contains("speed_limits"))
                    Greenfoot.setWorld(new InformationWindow(button.replace("information_", "").replace("_btn", "").replace("_" + Language.getInstance().getSelectedLanguage(), ""), 310, 260, 80, 335, 10.5f));
                else if (button.contains("crossing"))
                    Greenfoot.setWorld(new InformationWindow(button.replace("information_", "").replace("_btn", "").replace("_" + Language.getInstance().getSelectedLanguage(), ""), 310, 290, 80, 400, 9.0f));
                else if (button.contains("stop_sign"))
                    Greenfoot.setWorld(new InformationWindow(button.replace("information_", "").replace("_btn", "").replace("_" + Language.getInstance().getSelectedLanguage(), ""), 310, 295, 80, 410, 11.5f));
            }
            else if (button.startsWith("reset"))
            {
                Statistics.getInstance().resetAll();
                Greenfoot.setWorld(new StatisticsMenu());
            }
            else if (button.startsWith("cumulative"))
            {
                Greenfoot.setWorld(new MyWorld("cumulative"));
            }
         }
    }    
}
