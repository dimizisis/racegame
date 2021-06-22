import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Comparator;
import java.util.Objects;

/**
 * Class that represents a Car, which is autocontrolled.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class OtherCar extends SmoothMover
{
    private int speed;
    private boolean vertical = false;
    
    /**
     * Constructor for objects of class Car.
     */
    public OtherCar()
    {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        this.setImage(new GreenfootImage("Car_" + i + "_01.png"));
        this.speed = 2;
    }
    
    /**
     * Constructor for objects of class Car.
     * @param speed  the speed of the instance
     */
    public OtherCar(int speed)
    {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        this.setImage(new GreenfootImage("Car_" + i + "_01.png"));
        if (i != 2)
            this.getImage().rotate(180);
        this.speed = speed;
        move();
    }
    
    /**
     * Constructor for objects of class Car.
     * @param vertical  whether or not the car will move vertically.
     */
    public OtherCar(boolean vertical)
    {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        this.setImage(new GreenfootImage("Car_" + i + "_01.png"));
        this.vertical = vertical;
        if (vertical)
            this.setImage(new GreenfootImage("Car_" + i + "_01_v.png"));
        else
            if (i != 2)
                this.getImage().rotate(180);
        this.speed = 2;
        move();
    }
    
    /**
     * Constructor for objects of class Car.
     * @param speed  the speed of the instance
     * @param vertical  whether or not the car will move vertically.
     */
    public OtherCar(int speed, boolean vertical)
    {
        int i = ThreadLocalRandom.current().nextInt(1, 4);
        this.setImage(new GreenfootImage("Car_" + i + "_01.png"));
        this.vertical = vertical;
        if (vertical)
            this.setImage(new GreenfootImage("Car_" + i + "_01_v.png"));
        else
            if (i != 2)
                this.getImage().rotate(180);
        this.speed = speed;
        move();
    }
    
    /**
     * Act - do whatever the OtherCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getObjectsInRange(80, Pedestrian.class).isEmpty() || isFirstInOrder())
            if (!vertical)
                move(-speed);
            else
                setLocation(getExactX(), getExactY()+0.7);
        else
            stop();
    }
    
    /**
     * Checks if the car is first in the road (lowest X).
     * This method exists in order not to create traffic congestion.
     * 
     * @return  true if the car is first in order, false otherwise.
     */
    private boolean isFirstInOrder()
    {
        Actor frontCar = getObjectsInRange(80, OtherCar.class).stream().min(Comparator.comparing(OtherCar::getX)).orElse(null);
        if (Objects.nonNull(frontCar) && this.equals(frontCar))
            return true;
        return false;
    }
}
