import greenfoot.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that represents the traffic light.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class TrafficLight extends Actor
{
    private int state = 0; /* 0 for red, 1 for green */
    private long lastChanged = 0;
    
    /**
     * Constructor for objects of class TrafficLight.
     */
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
    
    /**
     * Changes the current state of the traffic light's instance (green to red and vice versa).
     */
    private void changeState()
    {
        int newState = 1 - state;
        if (newState == 1)
            setImage(new GreenfootImage("traffic_light_green.png"));
        else
            setImage(new GreenfootImage("traffic_light_red.png"));
        this.setState(newState);
    }
    
    /**
     * Sets the current state of the traffic light's instance.
     * 
     * @param newState  the new state that will be set.
     */
    private void setState(int newState)
    {
        this.state = newState;
    }
    
    /**
     * Returns the current state of the traffic light's instance.
     * 
     * @return  the current state of the traffic light's instance.
     */
    public int getState()
    {
        return this.state;
    }
    
}
