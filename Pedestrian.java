import greenfoot.*;

/**
 * Write a description of class Pedestrian here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedestrian extends Actor
{
    /**
     * Act - do whatever the Pedestrian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - 1);
    }    
}
