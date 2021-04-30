import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OtherCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OtherCar extends Actor
{
    
    private int speed;
    
    public OtherCar()
    {
        this.speed = 2;
    }
    
    public OtherCar(int speed)
    {
        this.speed = speed;
    }
    /**
     * Act - do whatever the OtherCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-this.speed);
    }    
}
