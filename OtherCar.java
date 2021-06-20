import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Comparator;
import java.util.Objects;

/**
 * Write a description of class OtherCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OtherCar extends SmoothMover
{
    
    private int speed;
    private boolean vertical = false;
    
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
        move();
    }
    
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
        if (getObjectsInRange(100, Pedestrian.class).isEmpty() || isFirstInOrder())
            if (!vertical)
                accelerate(1.2);
            else
                setLocation(getExactX(), getExactY()+0.2);
        else
            stop();
    }
    
    private boolean isFirstInOrder()
    {
        Actor frontCar = getObjectsInRange(80, OtherCar.class).stream().min(Comparator.comparing(OtherCar::getX)).orElse(null);
        if (Objects.nonNull(frontCar) && this.equals(frontCar))
            return true;
        return false;
    }
}
