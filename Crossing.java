import greenfoot.*;
import java.util.Objects;

/**
 * Write a description of class Crossing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crossing extends Actor
{
    private TrafficLight trafficLight;
    
    public Crossing()
    {
        trafficLight = null;
    }
    
    public Crossing(TrafficLight t)
    {
        this.trafficLight = t;
    }
    /**
     * Act - do whatever the Crossing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
