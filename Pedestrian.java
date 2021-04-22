import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class Pedestrian here.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Pedestrian extends Actor
{
    private int speed = 1;
    
    public Pedestrian()
    {
        setImage(new GreenfootImage("pedestrian_" + ThreadLocalRandom.current().nextInt(1, 3) + ".png"));
    }
    
    public Pedestrian(int speed)
    {
        this.speed = speed;
        setImage(new GreenfootImage("pedestrian_" + ThreadLocalRandom.current().nextInt(1, 3) + ".png"));
    }
    /**
     * Act - do whatever the Pedestrian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - speed);
    }    
}
