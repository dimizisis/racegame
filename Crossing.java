import greenfoot.*;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that represents the pedestrian crossing.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class Crossing extends Actor
{
    private TrafficLight trafficLight;
    private long lastPassed;
    private boolean hasPedestrians;
    
    /**
     * Constructor for objects of class Crossing.
     */
    public Crossing()
    {
        this.trafficLight = null;
        this.lastPassed = 0;
        this.hasPedestrians = true; /* has pedestrians by default */
    }
    
    /**
     * Constructor for objects of class Crossing.
     * @param hasPedestrians  whether or not this instance of crossing will contain pedestrians
     */
    public Crossing(boolean hasPedestrians)
    {
        this.hasPedestrians = hasPedestrians;
    }
    
    /**
     * Act - do whatever the Crossing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (this.hasPedestrians)
        {
            long currTime  = System.currentTimeMillis();
            if (currTime >= lastPassed + ThreadLocalRandom.current().nextInt(2000, 4000+1))
            {
                if (Objects.nonNull(trafficLight))
                {
                    if (trafficLight.getState() == 0)
                    {
                        pedestrianPass(ThreadLocalRandom.current().nextInt(1, 5));
                        lastPassed = currTime;
                    }
                }
                else
                {
                    pedestrianPass(ThreadLocalRandom.current().nextInt(1, 5));
                    lastPassed = currTime;
                }
            }
        }
    }
    
    /**
     * Adds randomly pedestrian to the specific instance
     * of crossing.
     * 
     * @param pedestrianNum the total count of pedestrians to pass
     */
    private void pedestrianPass(int pedestrianNum)
    {
        for (int i=0; i<pedestrianNum; ++i)
            getWorld().addObject(new Pedestrian(ThreadLocalRandom.current().nextInt(1, 4)), getX(), 700);
    }
    
    /**
     * Adds a traffic light to the specific instance of crossing.
     */
    public void addTrafficLight()
    {
        if (Objects.isNull(this.trafficLight))
            setTrafficLight();
            
    }
    
    /**
     * Creates and sets a traffic light to the specific instance of crossing.
     */
    private void setTrafficLight()
    {
        this.trafficLight = new TrafficLight();
        getWorld().addObject(this.trafficLight, getX(), 420);
    }
    
    /**
     * Returns the instance of the traffic light that is contained
     * to the crossing's instance (this).
     * 
     * @return the instance of the traffic light
     */
    public TrafficLight getTrafficLight()
    {
        return this.trafficLight;
    }
    
    /**
     * Returns whether or not a traffic light is contained to the
     * crossing instance (this).
     * 
     * @return true if a traffic light is contained, false otherwise.
     */
    public boolean hasTrafficLight()
    {
        return Objects.nonNull(this.getTrafficLight());
    }
}
