/**
 * Write a description of class SpeedLimitRange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedLimitRange  
{
    
    private int startX = -1;
    private int stopX = -1;
    private double speedLimit = -1.0;
    private SpeedSign speedSign = null;

    /**
     * Constructor for objects of class SpeedLimitRange
     */
    public SpeedLimitRange(int startX, int stopX, double speedLimit)
    {
        this.startX = startX;
        this.stopX = stopX;
        this.speedLimit = speedLimit;
    }
    
    public SpeedLimitRange(int startX, double speedLimit, SpeedSign speedSign)
    {
        this.startX = startX;
        this.speedLimit = speedLimit;
        this.speedSign = speedSign;
    }
    
    public int getStartX()
    {
        return this.startX;
    }
    
    public int getStopX()
    {
        return this.stopX;
    }
    
    public double getSpeedLimit()
    {
        return this.speedLimit;
    }
    
    public void setStopX(int x)
    {
        this.stopX = x;
    }
    
    public SpeedSign getSpeedSign()
    {
        return this.speedSign;
    }

}
