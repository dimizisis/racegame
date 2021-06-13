import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class OtherCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OtherCar extends SmoothMover
{
    
    private int speed;
    
    public OtherCar()
    {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        this.setImage(new GreenfootImage("Car_" + i + "_01.png"));
        this.speed = 2;
    }
    
    public OtherCar(int speed)
    {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        this.setImage(new GreenfootImage("Car_" + i + "_01.png"));
        if (i != 2)
            this.getImage().rotate(180);
        this.speed = speed;
    }
    /**
     * Act - do whatever the OtherCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getObjectsInRange(100, Pedestrian.class).isEmpty() && getObjectsInRange(100, OtherCar.class).isEmpty() && getObjectsInRange(100, Car.class).isEmpty())
            move(-this.speed);
        else
            move(0);
    }    
}
