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
    private boolean hasPedestrians;

    public Crossing()
    {
        this.trafficLight = null;
        this.lastPassed = 0;
        this.hasPedestrians = true; /* has pedestrians by default */
    }
    
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
            if (Objects.nonNull(trafficLight))
            {
                long currTime  = System.currentTimeMillis();
                if (currTime >= lastPassed + ThreadLocalRandom.current().nextInt(2000, 4000+1) && trafficLight.getState() == 0)
                {
                    pedestrianPass(ThreadLocalRandom.current().nextInt(1, 5));
                    lastPassed  = currTime;
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
