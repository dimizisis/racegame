import greenfoot.*;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class Crossing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crossing extends Actor
{
    private TrafficLight trafficLight;
    private long lastPassed;
    private int level;
    
    public Crossing()
    {
        trafficLight = null;
        lastPassed = 0;
    }
    
    public Crossing(TrafficLight t)
    {
        this.trafficLight = t;
    }
    
    public Crossing(int level)
    {
        this.level = level;
    }
    
    public Crossing(TrafficLight t, int level)
    {
        this.trafficLight = t;
        this.level = level;
    }
    
    /**
     * Act - do whatever the Crossing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Objects.nonNull(trafficLight))
        {
            if (level == 1)
            {
                long currTime  = System.currentTimeMillis();
                if (currTime >= lastPassed + ThreadLocalRandom.current().nextInt(2000, 4000+1) && trafficLight.getState() == 0)
                {
                    pedestrianPass(ThreadLocalRandom.current().nextInt(1, 5));
                    lastPassed  = currTime;
                }
            }
            else
            {
            }
        }
    }
    
    private void pedestrianPass(int pedestrianNum)
    {
        for (int i=0; i<pedestrianNum; ++i)
            getWorld().addObject(new Pedestrian(ThreadLocalRandom.current().nextInt(1, 4)), getX(), 700);
    }
    
    public void addTrafficLight()
    {
        if (Objects.isNull(this.trafficLight))
            setTrafficLight();
            
    }
    
    private void setTrafficLight()
    {
        this.trafficLight = new TrafficLight();
        getWorld().addObject(this.trafficLight, getX(), 420);
    }
    
    public TrafficLight getTrafficLight()
    {
        return this.trafficLight;
    }
    
    public boolean hasTrafficLight()
    {
        return Objects.nonNull(this.getTrafficLight());
    }
}
