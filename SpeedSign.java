import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedSign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedSign extends Actor
{
    private int speedLimit;
    
    public SpeedSign(String type)
    {
        setImage(new GreenfootImage(type + ".png"));
        this.speedLimit = Integer.parseInt(type.substring(type.length()-2));
    }
    
    /**
     * Act - do whatever the SpeedSign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
