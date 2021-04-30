import greenfoot.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
                getWorld().addObject(new InfoMessage("Accelerate Key: Right Arrow\nBackwards Move Key: Left Arrow\nBreak Key: B"), getWorld().getWidth()/2, getWorld().getHeight()/2);
            }
            //else if (button.equals("settings"))
            //{
            //}
            else
                Greenfoot.setWorld(new MyWorld(Integer.parseInt(button.substring(button.length()-1))));
         }
    }    
}
