/**
 * Class that represents the speed limit range.
 * 
 * @author Dimitrios Zisis
 * @version 1.0
 */
public class SpeedLimitRange  
{
    private int startX = -1;
    private int stopX = -1;
    private double speedLimit = -1.0;
    private SpeedSign speedSign = null;

    /**
     * Constructor for objects of class SpeedLimitRange.
     * 
     * @param startX  the x coordinate that the speed limit starts
     * @param stopX  the x coordinate that the speed limit ends
     * @param speedLimit  the double representation of the speed limit value
     */
    public SpeedLimitRange(int startX, int stopX, double speedLimit)
    {
        this.startX = startX;
        this.stopX = stopX;
        this.speedLimit = speedLimit;
    }
    
    /**
     * Constructor for objects of class SpeedLimitRange.
     * 
     * @param startX  the x coordinate that the speed limit starts
     * @param speedLimit  the double representation of the speed limit value
     * @param speedSign  a SpeedSign instance, which has set the limit
     */
    public SpeedLimitRange(int startX, double speedLimit, SpeedSign speedSign)
    {
        this.startX = startX;
        this.speedLimit = speedLimit;
        this.speedSign = speedSign;
    }
    
    /**
     * Constructor for objects of class SpeedLimitRange.
     * 
     * @param startX  the x coordinate that the speed limit starts
     * @param stopX  the x coordinate that the speed limit ends
     * @param speedLimit  the double representation of the speed limit value
     * @param speedSign  a SpeedSign instance, which has set the limit
     */
    public SpeedLimitRange(int startX, int stopX, double speedLimit, SpeedSign speedSign)
    {
        this.startX = startX;
        this.stopX = stopX;
        this.speedLimit = speedLimit;
        this.speedSign = speedSign;
    }
    
    /**
     * Returns the integer representation of the x coordinate that the speed limit starts
     * 
     * @return  the integer representation of the x coordinate that the speed limit starts
     */
    public int getStartX()
    {
        return this.startX;
    }
    
    /**
     * Returns the integer representation of the x coordinate that the speed limit ends
     * 
     * @return  the integer representation of the x coordinate that the speed limit ends
     */
    public int getStopX()
    {
        return this.stopX;
    }
    
    /**
     * Returns the double representation of the speed limit value
     * 
     * @return  the double representation of the speed limit value
     */
    public double getSpeedLimit()
    {
        return this.speedLimit;
    }
    
    /**
     * Sets the x coordinate that the speed limit ends
     * 
     * @param x  the new x coordinate that the speed limit ends
     */
    public void setStopX(int x)
    {
        this.stopX = x;
    }
    
    /**
     * Returns a SpeedSign instance, which has set the limit
     * 
     * @return  a SpeedSign instance, which has set the limit
     */
    public SpeedSign getSpeedSign()
    {
        return this.speedSign;
    }

}
