import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class TrafficLight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrafficLight extends Actor
{
    private int state = 0; /* 0 for red, 1 for green */
    private long lastChanged = 0;
    
    public TrafficLight()
    {
        setImage(new GreenfootImage("traffic_light_red.png"));
    }
    
    /**
     * Act - do whatever the TrafficLight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        long currTime  = System.currentTimeMillis();
        if (currTime >= lastChanged + ThreadLocalRandom.current().nextInt(6000, 9000+1))
        {
            changeState();
            lastChanged  = currTime;
        }
    }
    
    private void changeState()
    {
        int newState = 1 - state;
        if (newState == 1)
            setImage(new GreenfootImage("traffic_light_green.png"));
        else
            setImage(new GreenfootImage("traffic_light_red.png"));
        this.setState(newState);
    }
    
    private void setState(int newState)
    {
        this.state = newState;
    }
    
    public int getState()
    {
        return this.state;
    }
    
}
