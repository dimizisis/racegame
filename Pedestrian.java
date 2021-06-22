import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that represents the pedestrian,
 * whose instances are contained to some (or all)
 * instances of Crossing class.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Pedestrian extends Actor
{
    private int speed = 1; // 1 by default
    
    /**
     * Constructor for objects of class Pedestrian.
     */
    public Pedestrian()
    {
        setImage(new GreenfootImage("pedestrian_" + ThreadLocalRandom.current().nextInt(1, 3) + ".png"));
    }
    
    /**
     * Constructor for objects of class Pedestrian.
     * @param  the integer representation of the pedestrian's speed
     */
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
    
    /**
     * Increases the speed of this pedestrian instance.
     * Triggers when the main actor's (car's) horn is pressed
     * and no traffic light is present or traffic light exists
     * and is green.
     */
    public void increaseSpeed()
    {
        ++this.speed;
    }
}
