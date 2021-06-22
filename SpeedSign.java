import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that represents the speed sign.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class SpeedSign extends Actor
{
    /**
     * Constructor for objects of class SpeedSign.
     * @param type  type of the speed sign (limit)
     */
    public SpeedSign(String type)
    {
        setImage(new GreenfootImage(type + ".png"));
    }
        
    /**
     * Act - do whatever the SpeedSign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }
}
